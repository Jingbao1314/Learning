package myaop.test;

import reflaction.proxytest.*;

/**
 * Created by jingbao on 18-12-5.
 */
public class MyAop {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator" +
                ".saveGeneratedFiles","true");
        ITest myInvokeHander= (ITest) new MyInvokeHander()
                .bind(new Test(),new MyAdvise());
        myInvokeHander.test();
    }
}
