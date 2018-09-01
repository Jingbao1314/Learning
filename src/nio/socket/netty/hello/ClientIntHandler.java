package nio.socket.netty.hello;

/**
 * Created by andilyliao on 16-6-1.
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpMethod.POST;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static io.netty.handler.codec.stomp.StompHeaders.CONTENT_LENGTH;

public class ClientIntHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger  = LoggerFactory.getLogger(ClientIntHandler.class);
    @Override
    // 读取服务端的信息
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("HelloClientIntHandler.channelRead");
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        result.release();
        ctx.close();
        System.out.println("Server said:" + new String(result1));
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
//        System.out.println("STATE IS: " + body);
    }
    @Override
    // 当连接建立的时候向服务端发送消息 ，channelActive 事件当连接建立的时候会触发
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        logger.info("HelloClientIntHandler.channelActive");
//        System.out.println(ctx.channel().isActive());
//        System.out.println(ctx.channel().isOpen());
//        System.out.println(ctx.channel().isRegistered());
//        System.out.println(ctx.channel().isWritable());
//        String xx = "{phone:17602648916,name:xxx,password:123456}";
//        byte[] req = xx.getBytes();
//        ByteBuf buf = Unpooled.buffer(req.length);
//        buf.writeBytes(req);
//        ctx.writeAndFlush(buf);
//        logger.info("HelloClientIntHandler.channelActive");
        String msg = "reportCPU";
        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
        encoded.writeBytes(msg.getBytes());
        ctx.write(encoded);
        ctx.flush();
        System.out.println("xxxxxxxxxxxxxx"+encoded);
        System.out.println("xxxxxxxxxxxxxx"+msg);
    }

}

