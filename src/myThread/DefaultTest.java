package myThread;

/**
 * Created by jingbao on 18-4-14.
 */
interface DefaultInter{
    default void say(){
        System.out.println("DEFAULT");
    }
}
public class DefaultTest implements DefaultInter{
    public static void main(String[] args) {
        DefaultTest d=new DefaultTest();
        d.say();
    }
}
