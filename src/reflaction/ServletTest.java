package reflaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jingbao on 18-4-22.
 */
interface MyServlet{
     void doGet();
     void doPost();

}

class ServeletFirst implements MyServlet{
    public ServeletFirst(){}

    @Override
    public void doGet() {
        System.out.println("doGet");
    }

    @Override
    public void doPost() {
        System.out.println("doPost");

    }
}
class ServeletSecond implements MyServlet{
    public ServeletSecond(){}

    @Override
    public void doGet() {
        System.out.println("doGet2");
    }

    @Override
    public void doPost() {
        System.out.println("doPost2");
    }
}
public class ServletTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
       String url="https://www.baidu.com/ServeletFirst/doGet";
       String []result=url.split("/");
       Class cls=Class.forName("reflaction."+result[3]);
       Constructor con=cls.getConstructor();
       MyServlet servlet= (MyServlet) con.newInstance();
        Method doGet=cls.getMethod(result[4]);
        doGet.invoke(servlet);
    }
}
