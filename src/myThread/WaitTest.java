package myThread;

/**
 * Created by jingbao on 18-2-26.
 */
public class WaitTest extends Thread {
    public Object lock=new Object();
    public volatile static int flag=0;
    public static int  c=0;
    public void run(){
       // A a=new A();
        //B b=new B();
        Thread a=new Thread(){
            public  void run(){
                while (c<100){
                    synchronized (lock){
                        if(flag<2){
                            c=c+1;
                            System.out.println(flag);
                            flag++;
                        }else {
                            try {
                                lock.notify();
                                lock.wait();

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }

            }
        };
        a.start();
        Thread b=new Thread(){
            public  void run(){
                while (c<100){
                    synchronized (lock){
                        if(flag>0){
                            c=c+1;
                            System.out.println(flag);
                            flag--;
                        }else {
                            try {
                                lock.notify();
                                lock.wait();

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }

            }
        };
        b.start();


    }

    public static void main(String[] args) {
        WaitTest test=new WaitTest();
        test.start();

    }

}
