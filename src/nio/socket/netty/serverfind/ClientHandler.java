package nio.socket.netty.serverfind;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;

/**
 * Created by jingbao on 18-6-21.
 */
public class ClientHandler extends ChannelOutboundHandlerAdapter{

    @Override
    // 读取服务端的信息
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        result.release();
//        ctx.close();
        String s=new String(result1,"utf8");
        if(s.equals("1")||s=="1"){
            String x = "2";
            ByteBuf encoded = ctx.alloc().buffer(4 * x.length());
            encoded.writeBytes(x.getBytes());
            ctx.write(encoded);
            ctx.flush();
            System.out.println("|||"+s);

        }else{

            System.out.println("Server said:" + s);
            System.out.println("||");
        }
    }
    @Override
    // 当连接建立的时候向服务端发送消息 ，channelActive 事件当连接建立的时候会触发
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("+-+-+-+-+-+-+-+-+-+-");
        String msg = "Are you ok?";
        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
        encoded.writeBytes(msg.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }
}
