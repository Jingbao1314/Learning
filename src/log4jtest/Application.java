package log4jtest;

/**
 * Created by andilyliao on 16-8-15.
 */
import org.apache.log4j.Logger;

class Person{
    @Override
    public String toString() {
        return super.toString();
    }
}

public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            LOGGER.debug("Info log [" + i + "].");
            Thread.sleep(500);
        }


    }
    public  void xxx(Person p){
        try{

        }catch(Exception e){
            LOGGER.error("xxxx params:"+p.toString(),e);
        }
    }
}