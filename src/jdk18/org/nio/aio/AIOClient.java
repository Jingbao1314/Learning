package jdk18.org.nio.aio;

/**
 * Created by andilyliao on 16-8-23.
 */
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

public class AIOClient {

    public static void main(String... args) throws Exception {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        client.connect(new InetSocketAddress("localhost", 9888));
        client.write(ByteBuffer.wrap("test".getBytes())).get();
    }
}
