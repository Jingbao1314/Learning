package myThread;

import javax.swing.text.TabExpander;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jingbao on 18-2-26.
 */
public class RetrnetLoctTest extends Thread{
    public static ReentrantLock lock=new ReentrantLock();
    public Condition ThreeFlag=lock.newCondition();
    public Condition SixFlag=lock.newCondition();
    public int Flag=1;
    public void run(){
        Thread a=new Thread("a"){
            public void run(){
               try{
                   lock.lock();
                   while (Flag<4){
                       if(Flag<4){
                           System.out.println(Thread.currentThread().getName()+":"+Flag);
                           Flag++;

                       }

                   }
                   ThreeFlag.signal();
               }catch (Exception E){

               }finally {
                   lock.unlock();
               }






                while (Flag<7){
                    lock.lock();

                        ThreeFlag.signal();
                    lock.unlock();
                }




            }
        };
        a.start();
        Thread b=new Thread("b"){
            public void run(){
                lock.lock();
                try {
                    ThreeFlag.await();
                    while (Flag<7){
                        if(Flag<7){
                            System.out.println(Thread.currentThread().getName()+":"+Flag);
                            Flag++;
                        }
                    }
                    SixFlag.signal();
                    //lock.unlock();

                    //SixFlag.signal();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                    lock.unlock();
                }
                while (Flag<10){
                    lock.lock();
                    SixFlag.signal();
                    lock.unlock();

                }


            }




        };
        b.start();
        Thread c=new Thread("c"){
            public void run(){
                lock.lock();
                try {

                    SixFlag.await();
                    for (int i=7;i<10;i++){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                        Flag++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }




            }
        };


        c.start();
    }

    public static void main(String[] args) {
        RetrnetLoctTest test=new RetrnetLoctTest();
        test.start();
    }
}
