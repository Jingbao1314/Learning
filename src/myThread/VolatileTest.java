package myThread;

/**
 * Created by jingbao on 18-3-1.
 */
//http://blog.csdn.net/beiyetengqing/article/details/49583381：voliate问题
    //http://blog.csdn.net/u011116672/article/details/50147911:指令的重排序问题
    //http://blog.csdn.net/pzxwhc/article/details/48984209：指令的重排序问题
class MyVolatile{
    int a=1;
    int b=2;
    public void change()
    {
        a=3;
        b=a;
    }
    public void prient(){
        if(b==3&&a==1){
            System.out.println("a="+a);
        }else {
            System.out.println("a="+a+"b="+b);
        }
    }
}
public class VolatileTest {//https://www.cnblogs.com/paddix/p/5428507.html

    public static void main(String[] args) {
        while (true){
            final MyVolatile myVolatile=new MyVolatile();
            Thread a=new Thread(){
                public void run(){
                    try {
                        sleep(1000);
                        myVolatile.change();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            Thread b=new Thread(){
                public void run(){
                    try {
                        sleep(1000);
                        myVolatile.prient();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            a.start();
            b.start();



        }
    }

}
