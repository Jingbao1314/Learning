package reflaction.proxytest;

/**
 * Created by jingbao on 18-5-8.
 */
public class Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator" +
                ".saveGeneratedFiles","true");
        Animal myInvokeHander= (Animal) new MyInvokeHander().bind(new Dog());
        myInvokeHander.xx();
    }
}
///home/jingbao/IdeaProjects/untitled4/com/sun/proxy