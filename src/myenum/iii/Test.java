package myenum.iii;

/**
 * Created by andilyliao on 16-10-29.
 */
abstract class TTT{
    public abstract void dis(int a,int b);
}

public class Test {
    public static void main(String[] args) {
        TTT t=new TTT() {
            @Override
            public void dis(int a, int b) {

            }
        };
    }
}
