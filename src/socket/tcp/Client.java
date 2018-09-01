package socket.tcp;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)
            throws IOException {
//        Socket socket = new Socket("127.0.0.1", 30000);
//        System.out.println(socket.getLocalPort());
//        PrintStream ps = new PrintStream(socket.getOutputStream());
//        // 进行普通IO操作
//        ps.println("谢谢祝福！");
//        ps.flush();
//        // 将Socket对应的输入流包装成BufferedReader
//        BufferedReader br = new BufferedReader(
//                new InputStreamReader(socket.getInputStream()));
//        // 进行普通IO操作
//        String line = br.readLine();
//        System.out.println("来自服务器的数据：" + line);
//
//        ps.close();
//        // 关闭输入流、socket
//        br.close();
//        socket.close();
        Client.client();
    }
    public static void client() throws IOException {
        Socket socket=new Socket("127.0.0.1",8080);
        PrintStream ps=new PrintStream(socket.getOutputStream());
        ps.println("谢谢祝福!么么");
        ps.flush();
        InputStream in=socket.getInputStream();
        InputStreamReader read=new InputStreamReader(in);
        BufferedReader buff=new BufferedReader(read);
        String line =buff.readLine();
        System.out.println("来自服务器的数据：" + line);
        System.out.println(buff.readLine());
        buff.close();
        ps.close();
        socket.close();
    }
}
