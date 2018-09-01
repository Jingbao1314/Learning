package socket.jing;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingbao on 18-5-24.
 */
public class Client extends Thread{
    public  void run()  {
        Socket socket= null;
        try {
            socket = new Socket("127.0.0.1",7721);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream printStream= null;
        try {
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            printStream.print("么么！！");
            printStream.flush();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
