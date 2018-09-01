package socket.jing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingbao on 18-5-24.
 */
public class Server {
    public static ArrayList<Socket> socketList=new ArrayList<>(10);
    public static ServerSocket serverSocket;
    public static BufferedReader reader;
    public static PrintStream write;
    public static void accept() throws IOException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket=new ServerSocket(7721);
                    while (true){
                        Socket socket=serverSocket.accept();
                        socketList.add(socket);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        Thread serverThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String data=null;
                while (true){
                    for (Socket s:socketList) {
                        try {
                            reader=new BufferedReader(new InputStreamReader(s
                                    .getInputStream()));
                            while ((data=reader.readLine())!=null){
                                for (Socket ss:socketList) {
                                    if(s==ss){

                                    }else {
                                        write=new PrintStream(ss
                                                .getOutputStream());
                                        write.print(data);
                                        write.flush();

                                    }

                                }

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                }
            }
        });
        serverThread.start();
    }

    public static void main(String[] args) throws IOException {
        Server.accept();
    }
}
