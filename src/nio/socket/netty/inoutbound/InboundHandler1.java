package nio.socket.netty.inoutbound;

/**
 * Created by andilyliao on 16-6-1.
 */
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InboundHandler1 extends ChannelInboundHandlerAdapter {
    private static Logger   logger  = LoggerFactory.getLogger(InboundHandler1.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InboundHandler1.read");
        logger.info("InboundHandler1.channelRead: ctx :" + ctx);
        // 通知执行下一个InboundHandler
        ctx.fireChannelRead(msg);//通知执行下一个InboundHandler执行read
//        for(int i=0;i<10000000;i++){
//            ctx.fireChannelRead(msg);
//        }
//        while (true){
//            ctx.fireChannelRead(msg);
//        }


    }
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("**********");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("InboundHandler1.channelReadComplete");
//        ctx.flush();
    }

}
