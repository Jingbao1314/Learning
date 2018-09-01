package socket.http_1;

/**
 * Created by andilyliao on 16-5-24.
 */

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;
import sun.plugin2.main.server.HeartbeatThread;

import java.io.*;
import java.net.InetSocketAddress;

public class MyHttpServer {
    public static void server() throws IOException {
        HttpServerProvider provider=HttpServerProvider.provider();
        HttpServer server=provider.createHttpServer(new InetSocketAddress
                (8080),10);
        server.createContext("/meme",new MyHandler());
        server.setExecutor(null);
        server.start();
    }
    static class MyHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String response="meme";
            BufferedReader reader=new BufferedReader(new InputStreamReader
                    (httpExchange.getRequestBody()));
            String request="";
            while ((request=reader.readLine())!=null){
                System.out.println(request);
            }
            httpExchange.sendResponseHeaders(200,response.length());
            OutputStream out=httpExchange.getResponseBody();
            out.write(response.getBytes());
            out.flush();
            httpExchange.close();

        }
    }
    //启动服务，监听来自客户端的请求
    public static void httpserverService() throws IOException {
        HttpServerProvider provider = HttpServerProvider.provider();
        HttpServer httpserver =provider.createHttpServer(new InetSocketAddress(6666), 100);//监听端口6666,能同时接 受100个请求
        httpserver.createContext("/myApp", new MyHttpHandler());
        httpserver.setExecutor(null);
        httpserver.start();
        System.out.println("server started");
    }
    //Http请求处理类
    static class MyHttpHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {
            String responseMsg = "love";   //响应信息
            System.out.println(httpExchange.getRequestHeaders().get("Accept-Encoding"));
            InputStream in = httpExchange.getRequestBody(); //获得输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String temp = null;
            while((temp = reader.readLine()) != null) {
                System.out.println("client request:"+temp);
            }
            httpExchange.sendResponseHeaders(200, responseMsg.length()); //设置响应头属性及响应信息的长度
            OutputStream out = httpExchange.getResponseBody();  //获得输出流
            out.write(responseMsg.getBytes());
            out.flush();
            httpExchange.close();

        }
    }
    public static void main(String[] args) throws IOException {
        httpserverService();
//        server();
    }
}
