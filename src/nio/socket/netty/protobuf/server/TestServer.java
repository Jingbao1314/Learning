package nio.socket.netty.protobuf.server;


import nio.socket.netty.protobuf.framework.Server;

import java.io.IOException;

/**
 * Created by andilyliao on 17-4-9.
 */
public class TestServer {
    public static void main(String[] args) {
        try {
            Server s=new Server(8888);
            Login login=new Login();
            System.out.print("");
            s.start(login);//Login  ILogin  Idosomething
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
