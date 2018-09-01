package reflaction.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jingbao on 18-5-8.
 */
public class MyInvokeHander implements InvocationHandler{
    private Object dog;
    public Object bind(Object byAgency){
        dog=  byAgency;
        return Proxy.newProxyInstance(byAgency.getClass().getClassLoader(),
                byAgency.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("eat eat eat");
        return method.invoke(dog,args);
    }
}
