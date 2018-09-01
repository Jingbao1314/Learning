package socket.rpc.server;

//import org.socket.rpc.framework.Server;

import socket.rpc.framework.IDoSomethingIntf;
import socket.rpc.framework.Server;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by andilyliao on 17-4-9.
 */
public class TestServer {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        try {
            Server s=new Server(8888);
            Login login=new Login();
            s.start(login);//Login  ILogin  Idosomething
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
