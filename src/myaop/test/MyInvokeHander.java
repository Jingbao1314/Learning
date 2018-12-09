package myaop.test;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jingbao on 18-12-5.
 */
public class MyInvokeHander implements InvocationHandler{
    private MyAdvise advice;
    private Object agency;
    public Object bind(Object byAgency,MyAdvise advice){
        this.advice=advice;
        agency=  byAgency;
        return Proxy.newProxyInstance(byAgency.getClass().getClassLoader(),
                byAgency.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class c=this.advice.getClass();
        Object res=null;

        for (Method m :c.getMethods()) {
            if (m.isAnnotationPresent(MyPointcut.class)){
                MyPointcut pointcut= (MyPointcut) m.getAnnotation(MyPointcut.class);
                if (method.getName().equals(pointcut.name())){
                    if (m.isAnnotationPresent(MyBefore.class)){
                        this.advice.run();
                        return method.invoke(agency,args);
                    }else {
                        res=method.invoke(agency,args);
                        this.advice.run();
                    }
                }
            }
        }
        return res;
    }
}
