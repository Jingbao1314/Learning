package annotation.iv;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation {
    String value() ;
    String color() default "red";//设置默认值是"red"
    String[] value1() default {"abc","aaaaa"};
}

@MyAnnotation(value = "java",value1 ={"aaa","bbb"})
public class ApplyMyAnnotation {
    public static void main(String[] args) {
        if (ApplyMyAnnotation.class.isAnnotationPresent(MyAnnotation.class)) {// 判断此类上是否存在指定的注解类
            MyAnnotation annotation = (MyAnnotation) ApplyMyAnnotation.class
                    .getAnnotation(MyAnnotation.class);
            System.out.println("value="+annotation.value());
            System.out.println("color="+annotation.color());
            String[] strs=annotation.value1();
            for(String str:strs){
                System.out.println(str);
            }
        }
    }
}