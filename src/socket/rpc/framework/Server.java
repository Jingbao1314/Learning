package socket.rpc.framework;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * Created by andilyliao on 17-4-9.
 */
public class Server {
    private String res="";
    private Charset charset = Charset.forName("UTF-8");
    private Selector selector=Selector.open();
    private int port;
    private ServerSocketChannel server=null;
    private ServerSocket ss=null;
    public Server(int port) throws IOException {
        this.port=port;
//        this.ss=new ServerSocket(port);
        this.server=ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress("0.0.0.0", port);
        server.socket().bind(isa);
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);

    }
    public void start(IDoSomethingIntf dosomething) throws IOException, InvocationTargetException, IllegalAccessException {
//        while (true) {
//            Socket s = ss.accept();
//            DoThread doThread=new DoThread();
//            doThread.setSocket(s);
//            doThread.setiDosomething(dosomething);
//            doThread.start();
//        }
        while (selector.select()>0){
            for (SelectionKey key:selector.selectedKeys()) {
                selector.selectedKeys().remove(key);
                if(key.isAcceptable()){
                    ServerSocketChannel ss = (ServerSocketChannel)key.channel();
                    SocketChannel s=ss.accept();
                    s.configureBlocking(false);
                    System.out.println("accept");
                    s.register(selector,SelectionKey.OP_READ);
                    key.interestOps(SelectionKey.OP_ACCEPT);
                }
                if (key.isReadable()){
                   try{
                       System.out.println("resive something");
                       SocketChannel s= (SocketChannel) key.channel();
                       ByteBuffer buff=ByteBuffer.allocate(1024);
                       buff.clear();
                       String line="";
                       System.out.println("****");
                       while (s.read(buff)>0){
                           buff.flip();
                           line=line+charset.decode(buff);

                       }
                       if(line==null|line.equals("")){
                           System.out.println("close");
//                           key.channel().close();
                           key.cancel();
                           break;

                       }else{

                           key.interestOps(SelectionKey.OP_READ);

                       }
                       System.out.println("****"+line+"-------");
                       IDoSomethingIntf iDosomething=dosomething;
                       String str[]=line.split("\\|");
                       String classname=str[0];
                       String methodname=str[1];
                       Method[] m = iDosomething.getClass().getDeclaredMethods();
                       for (int i = 0; i < m.length; i++) {
                           String name = m[i].getName();
                           System.out.println("");
                           if (name.equals(methodname)) {
                               res = iDosomething.doSomething(m[i], line);
                           }

                       }

                       if (res.length() > 0) {
                           // 遍历该selector里注册的所有SelectionKey
                           for (SelectionKey sk : selector.keys()) {
                               System.out.println("");
                               // 获取该key对应的Channel
                               Channel targetChannel = sk.channel();
                               // 如果该channel是SocketChannel对象
                               if (targetChannel instanceof SocketChannel) {
                                   // 将读到的内容写入该Channel中
                                   SocketChannel dest = (SocketChannel) targetChannel;
                                   dest.write(charset.encode(res));
                               }
                           }
                       }
                   }catch (Exception e){

//                       key.cancel();
                       if (key.channel() == null) {
                           System.out.println("channel close");
                           key.channel().close();
                       }
                   }
                    //s.register(selector,SelectionKey.OP_WRITE);



                }

                if(key.channel().isOpen()){
                    if(key.isWritable()){
                        SocketChannel s= (SocketChannel) key.channel();
                        ByteBuffer buff=charset.encode(res);
                        buff.flip();
                        s.write(buff);
                        key.interestOps(SelectionKey.OP_WRITE);

                    }
                }

            }
        }


    }
}
