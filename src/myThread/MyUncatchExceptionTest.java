package myThread;

/**
 * Created by jingbao on 18-2-27.
 */
class MyException implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName()+":"+e);
    }
}
public class MyUncatchExceptionTest
{
    public static void main(String[] args) {
        ///System.out.println("main start");
        Thread.currentThread().setUncaughtExceptionHandler(new MyException());
        int a=10/0;
        System.out.println("main end");

    }
}
