package nio.socket.netty.hello;

public class ClientTest {
    public static void main(String[] args) throws Exception {
        TCPConn conn = new TCPConn();
        conn.TCPClient("127.0.0.1",7721);
    }
}
