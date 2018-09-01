package socket.rpc.server;

//import org.socket.rpc.idl.ILogin;

import socket.rpc.idl.ILogin;

/**
 * Created by andilyliao on 17-4-9.
 */
public class Login extends ILogin {
    @Override
    public boolean login(String username, String password) {
        System.out.println("adfadfadfsdf");
        return true;
    }
}
