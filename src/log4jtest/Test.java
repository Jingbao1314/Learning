package log4jtest;

import org.apache.log4j.Logger;

/**
 * Created by jingbao on 18-7-17.
 */
public class Test {
    private static final Logger LOGGER = Logger.getLogger(Test.class);
    public static void sayHello(String words){
        LOGGER.info("This is "+words);
        System.out.println(words);

    }
    public static void main(String[] args) {
        try {
            int a=7721/0;
        }catch (Exception e){
            LOGGER.error("This is error",e);
        }

    }
}
