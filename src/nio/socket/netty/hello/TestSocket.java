package nio.socket.netty.hello;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by andilyliao on 16-6-4.
 */
public class TestSocket {
    public static void main(String[] args) throws Exception {
        Socket s=new Socket("127.0.0.1",8080);
        OutputStream os=s.getOutputStream();
        os.write("bbb".getBytes());
        os.flush();
        s.close();
    }
}
