package mydi;

import java.util.concurrent.CountDownLatch;

/**
 * @author jijngbao
 * @date 19-3-16
 */
public class Test {
    public static void main(String[] args) {
        int a=10;
        int b=5;
        if (a==(b+10)&5==(b=(b-5))){
            System.out.println(b);
        }else {
            System.out.println("else"+b);
        }
    }
}
