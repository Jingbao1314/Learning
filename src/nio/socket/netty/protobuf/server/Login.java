package nio.socket.netty.protobuf.server;


import nio.socket.netty.protobuf.idl.ILogin;

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
