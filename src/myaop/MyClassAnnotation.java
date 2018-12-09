package myaop;

import java.lang.annotation.*;

/**
 * Created by jingbao on 18-12-5.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyClassAnnotation {
    String value() default "firstAnnotation";
}
