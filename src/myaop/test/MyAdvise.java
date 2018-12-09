package myaop.test;

/**
 * Created by jingbao on 18-12-5.
 */
public class MyAdvise {
    @MyBefore(name = "myaop.test")
    @MyPointcut(name = "test")
    public void run(){
        System.out.println("开始测试!---------------------------------");
    }
}
