package myThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

import static myThread.MyCountDownLatch.latch;

/**
 * Created by jingbao on 18-2-28.
 */
class Task extends Thread{
    public static int flag=1;
    //public static Object lock=new Object();
    public void run(){
        //synchronized (latch){
            while (flag<4){
                System.out.println("a"+flag);
                flag++;
                latch.countDown();
            }

       // }






    }
}
class TaskT extends Thread{
    public void run(){
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        for (int i=4;i<7;i++){
            System.out.println("b"+i);
        }



    }
}
public class MyCountDownLatch {//http://blog.csdn.net/yujin753/article/details/46125283
    public static CountDownLatch latch=new CountDownLatch(3);
    //public static int flag=1;
    //public static ExecutorService poll= Executors.newFixedThreadPool(6);
    public static void main(String[] args) {
        //
        Task task=new Task();
        task.start();
        TaskT t=new TaskT();
        t.start();

    }
}
