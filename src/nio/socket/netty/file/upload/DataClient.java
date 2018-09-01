package nio.socket.netty.file.upload;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.multipart.*;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;

public class DataClient {

    static final String logpath = "/disk/test/iotest/resources/log/";
    static final String ziped_logpath = "/disk/test/iotest/resources/ziped_log/";
    static HttpDataFactory dataFactory = new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE);
    static ChannelFuture channelFuture;

    public static void main(String args[]) throws Exception {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new DataClientInitializer());
            channelFuture = bootstrap.connect(new InetSocketAddress("localhost", 8080)).sync();
            HashSet<String> files = new HashSet<String>(Arrays.asList(new File(logpath).list()));
            HashSet<String> ziped_files = new HashSet<String>(Arrays.asList(new File(ziped_logpath).list()));
            for (String file : files) {
                if (!ziped_files.contains(file + ".zip")) {
                    DataClient dataClient = new DataClient();
                    dataClient.upLoad(new File(logpath + file));
                }
            }
            channelFuture.channel().close().sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    private void upLoad(File file) {
        System.out.println(file.getAbsolutePath());
        if (file.isHidden() || !file.isFile()) {
            System.out.println(file.getName() + "不存在");
            return;
        }
        try {
            HttpRequest request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, file.getName());
            HttpPostRequestEncoder bodyRequestEncoder = new HttpPostRequestEncoder(dataFactory, request, true);
            bodyRequestEncoder.addBodyAttribute("getform", "POST");
            bodyRequestEncoder.addBodyFileUpload("myfile", file, "application/x-zip-compressed", false);
            bodyRequestEncoder.finalizeRequest();
            Channel channel = channelFuture.channel();
            if (channel.isActive() && channel.isWritable()) {
                channel.writeAndFlush(request);

                if (bodyRequestEncoder.isChunked()) {
                    channel.writeAndFlush(bodyRequestEncoder).awaitUninterruptibly();
                }
                bodyRequestEncoder.cleanFiles();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
