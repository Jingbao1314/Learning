package nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * Created by jingbao on 18-4-15.
 */
public class NServer {
   private Selector selector=null;
   static final int PORT=30000;
   private Charset charset=Charset.forName("utf-8");
   public void init() throws IOException {
       selector=Selector.open();
       ServerSocketChannel server=ServerSocketChannel.open();
       InetSocketAddress isa=new InetSocketAddress("0.0.0.0",PORT);
       server.socket().bind(isa);
       server.configureBlocking(false);

       server.register(selector,SelectionKey.OP_ACCEPT);
       while (selector.select()>0){
           for (SelectionKey sk:selector.selectedKeys()){
               selector.selectedKeys().remove(sk);
               if(sk.isAcceptable()){
                   ServerSocketChannel ss= (ServerSocketChannel) sk.channel();
                   SocketChannel sc=ss.accept();
                   sc.configureBlocking(false);
                   sc.register(selector,SelectionKey.OP_READ);
                   sk.interestOps(SelectionKey.OP_ACCEPT);
               }
               if(sk.isReadable()){
                   SocketChannel sc= (SocketChannel) sk.channel();
                   ByteBuffer buff=ByteBuffer.allocate(1024);
                   String content="";
                   try{
                       while (sc.read(buff)>0){
                           buff.flip();
                           content+=charset.decode(buff);

                       }
                       if(content.equals("")){
                           sk.cancel();
                           break;
                       }
                       System.out.println("读取的内容：" + content);
                       sk.interestOps(SelectionKey.OP_READ);
                   }catch (Exception e){
                       if(sk.channel()!=null){
                           sk.channel().close();
                       }
                   }
                   if(content.length()>0){
                       for (SelectionKey key:selector.keys()) {
                           Channel channel=key.channel();
                           if (channel instanceof SocketChannel){
                               SocketChannel socketChannel= (SocketChannel) channel;
                               socketChannel.write(charset.encode(content));
                           }

                       }
                   }

               }

           }
       }


   }

    public static void main(String[] args) throws IOException {
        new NServer().init();
    }

}
