package nio.socket.netty.file.upload;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.*;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by bingoc on 16/4/21.
 */
public class DataClientInboundHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        System.out.println(msg.toString());
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.channel().close();
    }

}
