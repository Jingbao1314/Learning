package nio.socket;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

/**
 * Created by jingbao on 18-4-22.
 */
public class FileChnallTest {
    public static void main(String[] args) throws IOException {
        File f=new File("/home/jingbao/桌面/in");
        FileChannel inChnall=new FileInputStream(f).getChannel();
        FileChannel outChnall=new FileOutputStream(new File
                ("/home/jingbao/桌面/out")).getChannel();
        MappedByteBuffer map=inChnall.map(FileChannel.MapMode.READ_ONLY,0,f
                .length());
       // map.flip();
        Charset charset=Charset.forName("utf-8");
        CharsetDecoder decoder=charset.newDecoder();
        CharsetEncoder encoder=charset.newEncoder();
        CharBuffer charBuffer=decoder.decode(map);
        ByteBuffer byteBuffer=encoder.encode(charBuffer);
        charBuffer.flip();
        System.out.println(charBuffer.limit());




    }

}

