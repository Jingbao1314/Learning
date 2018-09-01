package socket.oobinline;

/**
 * Created by andilyliao on 16-5-22.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    public static void main(String[] args) throws Exception {
//        ServerSocket serverSocket = new ServerSocket(1234);
//        System.out.println("服务器已经启动，端口号：1234");
//        while (true) {
//            Socket socket = serverSocket.accept();
//            socket.setOOBInline(true);
//            InputStream in = socket.getInputStream();
//            InputStreamReader inReader = new InputStreamReader(in);
//            BufferedReader bReader = new BufferedReader(inReader);
//            System.out.println(bReader.readLine());
//            System.out.println(bReader.readLine());
//            socket.close();
//        }
       Server.server();
    }
    public static void server() throws IOException {
        ServerSocket serverSocket=new ServerSocket(7721);
        Socket socket=serverSocket.accept();
        socket.setOOBInline(true);
        BufferedReader reader=new BufferedReader(new InputStreamReader(socket
                .getInputStream()));
        String line=null;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
        socket.close();
    }
}
