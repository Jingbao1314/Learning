package nio.socket.netty.inoutbound;

/**
 * Created by andilyliao on 16-6-1.
 */
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutboundHandler1 extends ChannelOutboundHandlerAdapter {//继承ChannelHandlerAdapter也可以
    private static Logger   logger  = LoggerFactory.getLogger(OutboundHandler1.class);
    @Override
    // 向client发送消息
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("OutboundHandler1.write");
        logger.info("OutboundHandler1.write");
        String response = "I am ok!";
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("********************");
        ctx.fireChannelRead(msg);//通知执行下一个InboundHandler执行read

    }


}