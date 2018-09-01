package annotation.ii;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@interface Testable
{
}


public class MyTest
{
	// 使用@Test修饰info方法
	@Testable
	public void info()
	{
		System.out.println("info方法...");
	}
}
