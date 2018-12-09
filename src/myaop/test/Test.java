package myaop.test;

import java.util.concurrent.locks.Condition;

/**
 * Created by jingbao on 18-12-5.
 */
public class Test implements ITest{
    @Override
    public void test() {
        System.out.println("测试!测试!测试!");
    }

}
