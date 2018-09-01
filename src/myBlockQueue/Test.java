package myBlockQueue;
import javax.swing.text.html.FormSubmitEvent;
import java.lang.invoke.MethodHandle;
import static java.lang.invoke.MethodHandles.Lookup;
import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by jingbao on 18-5-3.
 */
//class GrandFather{
//    public GrandFather(){}
//    public void say() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        System.out.println("I am grandFather");
//    }
//}
//class Father extends GrandFather{
//    public Father(){}
//    public void say() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        System.out.println("I am father");
//    }
//}
//class Son extends Father{
//    public Son(){}
//    public void say() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        System.out.println("I an Son");
//        Class c=Class.forName("myBlockQueue.GrandFather");
//        Constructor con=c.getConstructor();
//        GrandFather grandFather= (GrandFather) con.newInstance();
//        grandFather.say();
//        System.out.println("I am son");
//    }
//}
public class Test {
//    class GrandFather{
//        public GrandFather(){}
//         void say() {
//            System.out.println("I am grandFather");
//        }
//    }
//    class Father extends GrandFather{
//        public Father(){}
//         void say(){
//            System.out.println("I am father");
//        }
//    }
//    class Son extends Father{
//        public Son(){}
//         void say(){
//            System.out.println("I an Son");
//            MethodType methodType=MethodType.methodType(void.class);
//             try {
//                 MethodHandle handle= lookup().findSpecial
//                         (GrandFather.class,"say",methodType,getClass());
//                 handle.invoke(this);
//             } catch (NoSuchMethodException e) {
//                 e.printStackTrace();
//             } catch (IllegalAccessException e) {
//                 e.printStackTrace();
//             } catch (Throwable throwable) {
//                 throwable.printStackTrace();
//             }
//             System.out.println("I am son");
//        }
//    }

//    public static void sayHello(Object arg){
//        System.out.println("Hello Object");
//    }
//    public static void sayHello(int arg){
//        System.out.println("Hello int");
//    }
//    public static void sayHello(long arg){
//        System.out.println("Hello long");
//    }
//    public static void sayHello(char arg){
//        System.out.println("Hello char");
//    }
//    public static void sayHello(char... arg){
//        System.out.println("Hello char...");
//    }
//    public static void sayHello(Character arg){
//        System.out.println("Hello Character");
//    }
//    public static void sayHello(Serializable arg){
//        System.out.println("Hello Serializable");
//    }
    static {
        i=10;
    System.out.println("**********");

    }
    static int i=5;
    {
        System.out.println("+++++++++"+i);
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Test.sayHello('a');
       // int [][][] i=new int[1][0][-1];
        //(new Test().new Son()).say();
        new Test();
        new Test();
        //Class.forName("myBlockQueue.Test");

    }
}
