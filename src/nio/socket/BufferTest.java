package nio.socket;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * Created by jingbao on 18-4-22.
 */
public class BufferTest {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String s="aaaaa";
        ByteBuffer buff=ByteBuffer.wrap(s.getBytes());
        System.out.println(buff.get());
        System.out.println(buff.limit()+"++++++"+buff.capacity());
    }
}
