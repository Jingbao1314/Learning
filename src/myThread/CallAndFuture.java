package myThread;



import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by jingbao on 18-2-27.
 */

class MyThread implements Callable {
    static int a;
    @Override
    public Object call() throws Exception {
        if(a<5){
            for (int j=0;j<5;j++){
                a++;
            }
        }else {
            for (int j=0;j<5;j++){
                a++;
            }
        }
        return a;
    }
    public MyThread(){}
}
public class CallAndFuture {//https://blog.csdn.net/chenliguan/article/details/54345993
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService threadPall=Executors.newCachedThreadPool();
//        Future<String> result=threadPall.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                String threadName=Thread.currentThread().getName();
//                return  threadName;
//            }
//        });
//        System.out.println("main start");
//        System.out.println(result.get());
//        System.out.println("main end");
//        threadPall.shutdown();

        MyThread myThread=new MyThread();
        FutureTask<Integer> future =null;
//        FutureTask只调用一次Callable或者Runnable所以不管new多少线程Callable只执行一次
//        你可以自己试试在call()方法那下一个断点你就明白了
        new Thread(future).start();
        for (int i=0;i<10;i++){

            future= new FutureTask<Integer>(myThread);
            new Thread(future).start();
            System.out.println(future.get());
        }

    }
}
