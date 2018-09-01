package nio.socket.netty.ssl.https;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class HttpServer {
//    keytool -genkeypair -alias ssltest.com -keysize 2048 -validity 365  -keyalg RSA -dname "CN=ssltest.com,OU=ssltest.com" -keypass 123456 -storepass 123456 -keystore ssltest.jks
//    keytool -export -alias ssltest.com -storepass 123456 -file ssltest.server.cer -keystore ssltest.jks
//    keytool -import -v -trustcacerts -alias ssltest.com -file ssltest.server.cer -keystore cacerts.jks -keypass 123456 -storepass 123456

    //-Djavax.net.debug=ssl,handshake
    private static Logger log = Logger.getLogger(HttpServer.class);

    public void startinbound(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
//            String TRUSTSTORE = "/disk/test/iotest/src/org/nio/netty/ssl/https/cacerts.jks";
//            File truststoreFile = new File("/disk/test/iotest/src/org/nio/netty/ssl/https/cacerts.jks");
//            File certFile = new File("/disk/test/iotest/src/org/nio/netty/ssl/https/ssltest.server.cer");
            File certFile = new File("/disk/test/iotest/src/org/nio/netty/ssl/https/luke1");
//            File keyFile = new File("/disk/test/iotest/src/org/nio/netty/ssl/https/ssltest.jks");
//            File keyFile = new File("/home/andilyliao/.ssh/id_rsa");
            File keyFile = new File("/disk/test/iotest/src/org/nio/netty/ssl/https/luke");
//            System.setProperty("javax.net.ssl.trustStore", TRUSTSTORE);
            ServerBootstrap b = new ServerBootstrap();
            final SslContext sslCtx;
            sslCtx = SslContext.newServerContext(
                    certFile, keyFile);
//            sslCtx = SslContext.newServerContext(null,
//                    certFile, keyFile,"123456");
//            SelfSignedCertificate ssc = new SelfSignedCertificate();
//            sslCtx = SslContext.newServerContext(ssc.certificate(), ssc.privateKey());
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(sslCtx.newHandler(ch.alloc()));
                            // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
                            ch.pipeline().addLast(new ReadTimeoutHandler(60, TimeUnit.SECONDS));
                            ch.pipeline().addLast(new WriteTimeoutHandler(60,TimeUnit.SECONDS));
                            ch.pipeline().addLast(new HttpResponseEncoder());
                            // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
                            ch.pipeline().addLast(new HttpRequestDecoder());
                            ch.pipeline().addLast(new HttpServerInboundHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(port).sync();

            f.channel().closeFuture().sync();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("aaaaaaaa");
        Thread inbound=new Thread(new Runnable() {
            @Override
            public void run() {
                HttpServer serverIn = new HttpServer();
                try {
                    System.out.println("aaaaaaaa");
                    serverIn.startinbound(18443);

                } catch (Exception e) {
                    log.error("Inbound Server crash!!!",e);
                    System.exit(1);
                }
            }
        });
        inbound.start();
        System.out.println("aaaaaaaa");
    }
}