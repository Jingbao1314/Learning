package myspring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by jingbao on 18-7-22.
 */
interface Idao{//依赖注入

}
//class Dao implements Idao{
//
//}
//class Xxxx implements Idao{
//
//}

public class Test {
    public Idao getDao() {
        return dao;
    }

    private Idao dao=null;


    public void setDao(Idao dao){
        this.dao=dao;

    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        Test t=new Test();
//        Properties pro=new Properties();
//        pro.load(new FileInputStream("/dad"));
//        pro.getProperty("key");
        t.setDao((Idao) Class.forName("myspping.Dao").newInstance());




    }
}
