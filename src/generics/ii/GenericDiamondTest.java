package generics.ii;

class MyClass<E,U,O>
{
	public <T,Y> MyClass(T t)
	{
		System.out.println("t is： " + t);
	}
}

public class GenericDiamondTest
{
	public static void main(String[] args)
	{
		MyClass<String,String,String> mc1 = new MyClass<>(5);
		//下面这个是错误的
//		MyClass<String> mc3 = new <Integer> MyClass<>(5);
	}
}
