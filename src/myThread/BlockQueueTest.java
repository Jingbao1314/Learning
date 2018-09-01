package myThread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by jingbao on 18-2-26.
 */
public class BlockQueueTest {//https://www.cnblogs.com/esther-qing/p/6492299.html
    public static void main(String[] args) throws InterruptedException {
//        ArrayBlockingQueue abq=new ArrayBlockingQueue(3);
//        abq.offer(7721);
//        abq.offer(123);
//        abq.offer(555);
//        System.out.println(abq.poll());
//        System.out.println(abq.poll());
//        System.out.println(abq.poll());
        ArrayBlockingQueue abq=new ArrayBlockingQueue(3);
        abq.put("ss");//当队列满的时候put会阻塞
        abq.put("1");
        abq.put("ddd");
        System.out.println(abq.take());




    }
}
