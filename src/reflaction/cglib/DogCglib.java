package reflaction.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jijngbao
 * @date 19-3-28
 */
public class DogCglib implements MethodInterceptor {
    private Object dog=null;
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("旺旺");
        methodProxy.invokeSuper(o, objects); //调用业务类（父类中）的方法
        return null;
    }
    public Object getInstance(Object target) {
        this.dog = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.dog.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
