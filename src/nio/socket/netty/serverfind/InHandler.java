package nio.socket.netty.serverfind;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.channels.SocketChannel;

/**
 * Created by jingbao on 18-6-20.
 */
public class InHandler extends ChannelInboundHandlerAdapter{
//

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr = new String(result1);
//        System.out.println("Client said:" + resultStr);
//        result.release();
        result.release();
        if(resultStr.equals("2")){
           msg="3";
           System.out.println("Client said:" + resultStr);



        }else {
            System.out.println("Client said:" + resultStr);
        }

        ctx.write(msg);
    }
//
}
