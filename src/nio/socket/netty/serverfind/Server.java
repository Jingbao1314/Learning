package nio.socket.netty.serverfind;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import nio.socket.netty.inoutbound.InboundHandler1;
import nio.socket.netty.inoutbound.InboundHandler2;
import nio.socket.netty.inoutbound.OutboundHandler1;
import nio.socket.netty.inoutbound.OutboundHandler2;

import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.*;

/**
 * Created by jingbao on 18-6-20.
 */
public class Server {
    public void start(int port){
        Charset charset=Charset.forName("utf8");
//        InHandler inHandler=new InHandler();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
//                            map.add((SocketChannel) ch);
//                            InHandler inHandler=new InHandler();
                            // 注册两个OutboundHandler，执行顺序为注册顺序的逆序，所以应该是OutboundHandler2 OutboundHandler1

                            ch.pipeline().addLast(new OutHandler());
                            System.out.println();
                            // 注册两个InboundHandler，执行顺序为注册顺序，所以应该是InboundHandler1 InboundHandler2
                            ch.pipeline().addLast(new InHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128).option
                    (ChannelOption.TCP_NODELAY,true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
//

            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new Server().start(7721);
    }
}
