package nio.socket.netty.protobuf.framework;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import nio.socket.netty.inoutbound.OutboundHandler1;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by andilyliao on 17-4-9.
 */
public class Server {
    private EventLoopGroup bossGroup=new NioEventLoopGroup();
    private EventLoopGroup workGroup=new NioEventLoopGroup();
    private ServerBootstrap server=new ServerBootstrap();
    private int port;
    private ServerSocket ss=null;
    private IDoSomethingIntf iDosomething=null;
    public Server(int port) throws IOException {
        this.port=port;
        this.ss=new ServerSocket(port);
    }
    public void start(IDoSomethingIntf dosomething) throws IOException {
//        while (true) {
//            Socket s = ss.accept();
//            DoThread doThread=new DoThread();
//            doThread.setSocket(s);
//            doThread.setiDosomething(dosomething);
//            doThread.start();
//        }
        iDosomething=dosomething;
        server.group(bossGroup,workGroup).channel(NioServerSocketChannel
                .class).childHandler(new ChannelInitializer() {

            @Override
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast(new OutboundHandler1());
                channel.pipeline().addLast(new MyInHandler(iDosomething));
            }
        }).option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);


    }
}
class Result{
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
class MyOutHandler extends ChannelOutboundHandlerAdapter {
    @Override
    // 向client发送消息
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        String response = (String) msg;
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }


}
class MyInHandler extends ChannelInboundHandlerAdapter{private
    IDoSomethingIntf iDosomething=null;
    public MyInHandler(IDoSomethingIntf iDosomething){
        this.iDosomething=iDosomething;
    }
    @Override
    // 读取Client发送的信息，并打印出来
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        logger.info("InboundHandler2.channelRead: ctx :" + ctx);
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr = new String(result1);
        String str[]=resultStr.split("\\|");
        String classname=str[0];
        String methodname=str[1];
        String res="";
        Method[] m = iDosomething.getClass().getDeclaredMethods();
        for (int i = 0; i < m.length; i++) {
            String name = m[i].getName();
            System.out.println("");
            if (name.equals(methodname)) {
                System.out.print("");
                res = iDosomething.doSomething(m[i], resultStr);
            }

        }

        ctx.write(res);
    }

}