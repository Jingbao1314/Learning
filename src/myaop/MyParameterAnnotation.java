package myaop;

/**
 * Created by jingbao on 18-12-5.
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface MyParameterAnnotation {

    MyAopParameterOPType[] opType();

    Class<?> paraType();
}