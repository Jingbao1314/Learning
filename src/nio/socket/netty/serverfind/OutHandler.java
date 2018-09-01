package nio.socket.netty.serverfind;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingbao on 18-6-20.
 */
public class OutHandler extends ChannelOutboundHandlerAdapter{
    ExecutorService threadPall= Executors.newFixedThreadPool(1);
    volatile boolean flag=true;
    @Override
    // 向client发送消息
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if(msg.equals("3")){
//            flag=true;
            String x = "3";
            ByteBuf encoded = ctx.alloc().buffer(4 * x.length());
            encoded.writeBytes(x.getBytes());
            ctx.write(encoded);
            ctx.flush();


        }else {
            String response = "么么";
            ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
            encoded.writeBytes(response.getBytes());
            ctx.write(encoded);
            ctx.flush();
        }
//        String response = "么么";
//        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
//        encoded.writeBytes(response.getBytes());
//        ctx.write(encoded);
//        ctx.flush();
        threadPall.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while ((ctx.channel().isActive())){
                    if(flag){
                        System.out.println("push");
                        String response = "1";
                        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
                        encoded.writeBytes(response.getBytes());
                        ctx.write(encoded);
                        ctx.flush();
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        flag=false;
                    }else {
                        try {
                            System.out.println("notPush");
                            flag=true;
                            TimeUnit.SECONDS.sleep(15);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }
        });

    }
}
