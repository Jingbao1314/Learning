package socket.http_1;

/**
 * Created by andilyliao on 16-5-24.
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws IOException {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        // 测试并发对MyHttpServer的影响
//        for (int i = 0; i < 20; i++) {
//            Runnable run = new Runnable() {
//                public void run() {
//                    try {
//                        startWork();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//            exec.execute(run);
//        }
//        exec.shutdown();// 关闭线程池
        startWork();

    }

    public static void startWork() throws IOException {
        URL url = new URL("http://127.0.0.1:8080/meme");
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setDoOutput(true);
        urlConn.setDoInput(true);
        urlConn.setRequestMethod("POST");
        // 测试内容包
        String teststr = "this is a test message";
        OutputStream out = urlConn.getOutputStream();
        out.write(teststr.getBytes());
        out.flush();
        int flag=urlConn.getContentLength();
        while ( flag!= -1) {
            System.out.println(urlConn.getContentLength());
            if (urlConn.getResponseCode() == 200) {
                InputStream in = urlConn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String temp = "";
                while ((temp = reader.readLine()) != null) {
                    System.err.println("server response:" + temp);// 打印收到的信息
                }
                flag=-1;
                reader.close();
                in.close();
                urlConn.disconnect();
            }
        }
    }
    public static void work() throws IOException {
        URL url=new URL("http://nyzc.xn121.com/zcdt/11/1890204.shtml");
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
        System.out.println(connection.getRequestMethod());
        System.out.println(connection.getHeaderField(0));
        System.out.println(connection.getResponseMessage());
        System.out.println(connection.getResponseCode());
       BufferedReader reader=new BufferedReader(new InputStreamReader
               (connection.getInputStream()));
       String repson="";
       while ((repson=reader.readLine())!=null){
           System.out.println(repson.trim());
       }
    }
}