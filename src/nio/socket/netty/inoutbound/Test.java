package nio.socket.netty.inoutbound;

/**
 * Created by jingbao on 18-6-12.
 */
interface Ihandler{
    void doSome();
}
class Handler implements Ihandler{
    public Handler(){
        doSome();
    }

    @Override
    public void doSome() {
        System.out.println("Handler");
    }
}

class Handler2 implements Ihandler{
    public Handler2(){
        doSome();
    }

    @Override
    public void doSome() {
        System.out.println("Handler2");
    }
}

abstract class My{
    public void say(){
        x();
    }
    public abstract void x();
}
public class Test {
    public static void main(String[] args) {
//        My my=new My() {
//            @Override
//            public void x() {
//                new Handler();
//                new Handler2();
//            }
//        };
//        my.say();


    }
}
