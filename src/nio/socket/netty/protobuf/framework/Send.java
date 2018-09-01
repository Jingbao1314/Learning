package nio.socket.netty.protobuf.framework;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import nio.socket.netty.inoutbound.HelloClientIntHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by andilyliao on 17-4-9.
 */
public class Send {//
    private String ip;
    private int port;
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    public Send(String ip, int port) throws IOException {
        this.ip=ip;
        this.port=port;
    }
    public String sendsomething(String str) throws IOException {
        try {
            System.out.print("");
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(new HelloClientIntHandler());
                }
            });

            // Start the client.
            ChannelFuture f = b.connect(ip, port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
        return null;

    }

}
class In extends ChannelInboundHandlerAdapter{


}
class Out extends ChannelOutboundHandlerAdapter{


}
