package nio.socket.netty.udp;

/**
 * Created by andilyliao on 16-5-27.
 */
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientTest {
    public static void res(DatagramPacket packet){
        try {
//            ByteBuf buf = (ByteBuf) packet.copy().content();
//            ByteBuf buf  =null;
            byte[] req = packet.getData();
//            buf.readBytes(req);
            String body = null;
            body = new String(req, "UTF-8");
            System.out.println(body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        DatagramSocket sendSocket = new DatagramSocket();
        String mes = "我是设备！";
        byte[] buf = mes.getBytes("UTF-8");
        int port = 9999;
        InetAddress ip = InetAddress.getLocalHost();
        DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, ip,
                port);
        DatagramPacket res = new DatagramPacket(buf, buf.length, ip,
                port);
        sendSocket.send(sendPacket);
        sendSocket.receive(res);
        res(res);
//        sendSocket.getChannel().
        sendSocket.close();
    }

}
