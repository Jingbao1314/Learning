package reflaction;


import jdk.nashorn.internal.parser.JSONParser;
//import com.google.gson.Gson;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * Created by jingbao on 18-4-24.
// */
//class Student{
//    public static int i=5;
//    static {
//        i=10;
//    }
//
//}

//class VolatileTest {
//    public volatile int inc = 0;
//
//    public void increase() {
//        inc++;
//    }
//    public void minus(){inc--;}
//}
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException {
//
//        System.out.println(Student.i);
//        final VolatileTest test=new VolatileTest();
//        final CountDownLatch cdl=new CountDownLatch(10);
//        for(int i=0;i<10;i++){
//           if(i%2==0){
//               new Thread(){
//                   public void run() {
//                       for(int j=0;j<10000;j++) {
//                           test.increase();
//                       }
//                       cdl.countDown();
//                   }
//               }.start();
//           }else {
//               new Thread(){
//                   public void run() {
//                       for(int j=0;j<10000;j++) {
//                           test.minus();
//                       }
//                       cdl.countDown();
//                   }
//               }.start();
//           }
//        }
//        cdl.await();
//
//        System.out.println(test.inc);

//        System.out.println(Test.a);
//        Class.forName("reflaction.Test")
// ;
        //Student student=new Student();
//        student.setName("test");
//        Integer a=1;
//        Integer b=2;
//        Integer c=3;
//        Integer d=3;
//        Integer e=128;
//        Integer f=128;
//        Long g=3L;
//        System.out.println(c==d);
//        System.out.println(e==f);
//        System.out.println(c==(a+b));
//        System.out.println(c.equals(a+b));
//        System.out.println(g==(a+b));
//        System.out.println(g.equals(a+b));
//        StringBuffer str=new StringBuffer();
//        str.append("2121");
//        str.append("sdhaswewjdgh");
//        str.append("21qqw21");
//        str.append("sdhasjdweqwgh");
//        str.append("21dw21");
//        str.append("sdhdsasjdgh");
//        System.out.println(str.toString());

       Thread thread=null;
       int i=0;
       while (true){
           System.out.println("start");
//           if(thread==null){
//               synchronized (Thread.class){
//                   if(thread==null){
//                       thread=new Thread(new Runnable() {
//                           @Override
//                           public void run() {
//                               System.out.println("++++++");
////                               try {
//////                                   TimeUnit.SECONDS.sleep(2);
////                               } catch (InterruptedException e) {
////                                   e.printStackTrace();
////                               }
//                           }
//                       });
//                   }
//               }
//           }
//           thread.start();
           if(i%2==0){
               new Test();
           }
           TimeUnit.SECONDS.sleep(5);

       }





    }
//    static {
//        System.out.println("sssss");
//        a=5;
//    }
//    public static int a =10;
//
}
