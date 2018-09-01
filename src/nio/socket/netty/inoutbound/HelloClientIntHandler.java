package nio.socket.netty.inoutbound;

/**
 * Created by andilyliao on 16-6-1.
 */
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloClientIntHandler extends ChannelInboundHandlerAdapter {
    private static Logger   logger  = LoggerFactory.getLogger(HelloClientIntHandler.class);
    @Override
    // 读取服务端的信息
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("HelloClientIntHandler.channelRead");
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        result.release();
        ctx.close();
        System.out.println("Server said:" + new String(result1).equals("a"));
    }
    @Override
    // 当连接建立的时候向服务端发送消息 ，channelActive 事件当连接建立的时候会触发
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("+-+-+-+-+-+-+-+-+-+-");
        logger.info("HelloClientIntHandler.channelActive");
        String msg = "Are you ok?";
        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
        encoded.writeBytes(msg.getBytes());
        ctx.write(encoded);
        ctx.flush();
//        StringBuffer head = new StringBuffer();
//        // 这些是必须的
//        head.append("POST / HTTP/1.1" + SEQUENCE);
//        head.append("Host:" + "http://127.0.0.1:8888" + SEQUENCE + SEQUENCE);
//        // 这些是可选的
//        head.append("Accept:text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//        head.append("Accept-Language:zh-CN,zh;q=0.8");
//        head.append("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36");
//        ByteBuf encoded = ctx.alloc().buffer(4 * head.length());
//        encoded.writeBytes(head.toString().getBytes());
//        ctx.write(encoded);
//        ctx.flush();
    }
}

