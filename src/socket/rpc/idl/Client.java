package socket.rpc.idl;

//import org.socket.rpc.framework.Send;

import socket.rpc.framework.Send;

import java.io.IOException;

/**
 * Created by andilyliao on 17-4-9.
 */
public class Client {
    public boolean login(String ip, int port, String username, String password) throws IOException {
        Send send=new Send(ip,port);
        String res=send.sendsomething("org.socket.rpc.idl.ILogin|login|"+username+"|"+password);
        switch (res){
            case "TRUE":
                return true;
            default:
                return false;
        }
    }
}
