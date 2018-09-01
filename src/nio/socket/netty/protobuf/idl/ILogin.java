package nio.socket.netty.protobuf.idl;

/**
 * Created by andilyliao on 17-4-9.
 */
public abstract class ILogin extends IDosomething {
    public abstract boolean login(String username, String password);
}
