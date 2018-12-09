package socket.oobinline;

import java.io.*;
import java.net.Socket;

/**
 * Created by andilyliao on 16-5-22.
 */
public class Client {
    public static void main(String[] args) throws Exception {
//        Socket socket = new Socket("127.0.0.1", 1234);
//        socket.setOOBInline(true);
//        OutputStream out = socket.getOutputStream();
//        OutputStreamWriter outWriter = new OutputStreamWriter(out);
//        outWriter.write(67);              // 向服务器发送字符"C"
//        outWriter.write("hello world\r\n");
//
//        socket.sendUrgentData(65);        // 向服务器发送字符"A"
//        socket.sendUrgentData(322);        // 向服务器发送字符"B"
//        //16个0 00000001 01000010          //sendUrgentData只发送整型数的低字节  01000010是66
//        outWriter.flush();
//        socket.close();
          Client.client();
    }
    public static void client() throws IOException {
        Socket socket=new Socket("127.0.0.1",7721);
        socket.setOOBInline(true);
//        PrintStream printStream=new PrintStream(socket.getOutputStream());
//        printStream.print("么么！");
//        printStream.write(66);
        OutputStreamWriter writer=new OutputStreamWriter(socket
                .getOutputStream());
        writer.write(66);
        writer.write("么么！");
        socket.sendUrgentData(65);//
        socket.sendUrgentData(65);
        socket.sendUrgentData(65);

//        printStream.flush();
//        printStream.close();
        writer.flush();
        socket.close();
    }
}
