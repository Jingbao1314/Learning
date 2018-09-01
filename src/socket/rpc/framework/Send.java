package socket.rpc.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by andilyliao on 17-4-9.
 */
public class Send {//
    private Charset charset=Charset.forName("utf8");
    private Selector selector=Selector.open();
    private String ip;
    private int port;
    private Socket socket=null;
    private volatile String line=" ";
    private SocketChannel client=null;
    public Send(String ip, int port) throws IOException {
        this.ip=ip;
        this.port=port;
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", port);
//        socket=new Socket(ip,port);

        client=SocketChannel.open(isa);
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);



    }
    public String sendsomething(String str) throws IOException {
//        PrintStream ps = new PrintStream(socket.getOutputStream());
//        // 进行普通IO操作
//        ps.println(str);
//        ps.flush();
//        BufferedReader br = new BufferedReader(
//                new InputStreamReader(socket.getInputStream()));
//        String line = br.readLine();
//        return line;
//        String s="org.socket.rpc.idl.ILogin|login|"+"aaa"+"|"+"aaa";
        System.out.println("sendsomething");
        SendMethod method=new SendMethod();
        method.start();
        ByteBuffer buff=charset.encode(str);
//        System.out.println(buff.get());
        client.write(buff);
        System.out.println("end");


        while (line==" "){
            line=method.getResult();


        }
        System.out.println(line+"-------");

        return line;

    }


    class SendMethod extends Thread{
        private volatile String result=" ";
        public String getResult(){
            return this.result;
        }
        public void run(){
            try {
                while (selector.select()>0){
                    System.out.println("read");
                    for (SelectionKey key:selector.selectedKeys()) {
                        selector.selectedKeys().remove(key);
                        if(key.isReadable()){
                            ByteBuffer buffer=ByteBuffer.allocate(1024);
                            SocketChannel s= (SocketChannel) key.channel();
                            buffer.clear();
                             while (s.read(buffer)>0){
                                buffer.flip();
                                result=result+charset.decode(buffer);

                            }
                            result=result.trim();
                            System.out.println(result.trim());System.out.println("read end");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
