package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingbao on 18-5-22.
 */

class MyServer{
    public static void start(){
        try {
            ServerSocket serverSocket=new ServerSocket(8080);
            Socket socket=serverSocket.accept();
            socket.setSoTimeout(10);
            InputStream in=socket.getInputStream();
            byte[] buff=new byte[1024];
            String res=null;
            int len=0;
            while ((len=in.read(buff))>0){
                System.out.println("++++++++");
                System.out.println(new String(buff,0,len,"utf-8"));
                System.out.println("++++++++");


            }
//            System.out.println("++++++++");
//            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class MyClient{
    public static void start(){
        try {
            Socket socket=new Socket("localhost",8080);
            OutputStream out=socket.getOutputStream();
            out.write("aaa".getBytes());
            out.write(65);
            out.write(66);
            out.write(67);

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

public class Test {
    public static CountDownLatch latch=new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException, IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("dasdas");
                MyServer.start();
//                try {
//                    Myserver.start();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                //latch.countDown();
                System.out.println("dasdas");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        //latch.await();


//        MyClient.start();
    }
}
