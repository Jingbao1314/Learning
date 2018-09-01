package socket.rpc.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by andilyliao on 17-8-11.
 */
public interface IDoSomethingIntf {
    String doSomething(Method m, String param) throws InvocationTargetException, IllegalAccessException;
}
