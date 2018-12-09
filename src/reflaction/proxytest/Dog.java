package reflaction.proxytest;

/**
 * Created by jingbao on 18-5-8.
 */
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("Dog eat bone");
    }

    @Override
    public void xx() {
        System.out.println("xxxxxx");
    }
}
