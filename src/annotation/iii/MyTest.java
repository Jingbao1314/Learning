package annotation.iii;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Testable {
}
class ProcessorTest {//效率 和 灵活性   性能 安全
    public static void process(String clazz)
            throws ClassNotFoundException {
        int passed = 0;
        int failed = 0;
        // 遍历clazz对应的类里的所有方法
        for (Method m : Class.forName(clazz).getMethods()) {
            // 如果该方法使用了@Testable修饰
            if (m.isAnnotationPresent(Testable.class)) {
                try {
                    // 调用m方法
                    m.invoke(null);
                    // 测试成功，passed计数器加1
                    passed++;
                } catch (Exception ex) {
                    System.out.println("方法" + m + "运行失败，异常："
                            + ex.getCause());
                    // 测试出现异常，failed计数器加1
                    failed++;
                }
            }
        }
        // 统计测试结果
        System.out.println("共运行了:" + (passed + failed)
                + "个方法，其中：\n" + "失败了:" + failed + "个，\n"
                + "成功了:" + passed + "个！");
    }
}

public class MyTest {
    // 使用@Testable注解指定该方法是可测试的
    @Testable
    public static void m1() {
        System.out.println("m1");
    }

    public static void m2() {
        System.out.println("m2");
    }

    // 使用@Testable注解指定该方法是可测试的
    @Testable
    public static void m3() {
        System.out.println("m3");
        throw new IllegalArgumentException("参数出错了！");
    }
    @Testable
    public static void m4() {
        System.out.println("m4");
    }

    // 使用@Testable注解指定该方法是可测试的
    @Testable
    public static void m5() {
        System.out.println("m5");
    }

    public static void m6() {
        System.out.println("m6");
    }

    // 使用@Testable注解指定该方法是可测试的
    @Testable
    public static void m7() {
        System.out.println("m7");
        throw new RuntimeException("程序业务出现异常！");
    }

    public static void m8() {
        System.out.println("m8");
    }


    public static void main(String[] args)
            throws Exception {
        // 处理MyTest类
        ProcessorTest.process("annotation.iii.MyTest");
    }
}
