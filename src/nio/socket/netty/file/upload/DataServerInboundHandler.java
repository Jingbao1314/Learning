package nio.socket.netty.file.upload;

import com.sun.nio.zipfs.ZipFileSystem;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.*;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;


public class DataServerInboundHandler extends SimpleChannelInboundHandler<HttpObject> {

    private static final Logger logger = Logger.getLogger(DataServerInboundHandler.class.getName());
    private HttpRequest request;
    private ChannelHandlerContext channelHandlerContext;
    private static final HttpDataFactory factory =
            new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE); // Disk if size exceed
    private HttpPostRequestDecoder decoder;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.toString());
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        System.out.println(httpObject.toString());
        this.channelHandlerContext = ctx;

        if (httpObject instanceof HttpRequest) {
            request = (HttpRequest) httpObject;

           String uri = request.uri();

            if (request.method() == HttpMethod.POST) {
                if (decoder != null) {
                    decoder.cleanFiles();
                    decoder = null;
                }
                try {
                    decoder = new HttpPostRequestDecoder(factory, request);
                } catch (Exception e) {
                    e.printStackTrace();
                    channelHandlerContext.channel().close();
                    return;
                }
            }
        }

        if (decoder != null && httpObject instanceof HttpContent) {
            HttpContent chunk = (HttpContent) httpObject;

            try {
                decoder.offer(chunk);
            } catch (Exception e) {
                e.printStackTrace();
                channelHandlerContext.channel().close();
                return;
            }

            readHttpDataChunkByChunk();

            if (chunk instanceof LastHttpContent) {
                return;
            }
        }
    }

    private void readHttpDataChunkByChunk() throws IOException {
        try {
            while (decoder.hasNext()) {
                InterfaceHttpData data = decoder.next();
                if(data != null){
                    try {
                        System.out.println("+++++++++++++++");
                        System.out.println(data.toString());
                        writeHttpData(data);
                        System.out.println("+++++++++++++++");
                    }finally {
                        data.release();
                    }

                }
            }
        } catch (HttpPostRequestDecoder.EndOfDataDecoderException e) {
            // ignore this as it is expected
        }
    }

    private void writeHttpData(InterfaceHttpData data) throws IOException {
        System.out.println("-------------------------");
        if(data.getHttpDataType() == InterfaceHttpData.HttpDataType.FileUpload) {
            FileUpload fileUpload = (FileUpload)data;
            if(fileUpload.isCompleted()) {
                System.out.println(fileUpload.isInMemory());

                File result = new File(fileUpload.getFilename());
                System.out.println("00000000000000000000000: "+result.getAbsoluteFile());
                OutputStream os=new FileOutputStream(result);
                os.write(fileUpload.get());
                os.flush();
                os.close();
            }
        }
    }
}
