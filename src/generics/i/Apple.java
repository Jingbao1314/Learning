package generics.i;

// 定义Apple类时使用了泛型声明
public class Apple<T> {
    // 下面代码错误，不能在静态变量声明中使用类型形参
//	static T info;
    // 使用T类型形参定义实例变量
    // 下面代码错误，不能在静态方法声明中使用类型形参
//	public static void bar(T msg){}
    private T info;

    public Apple() {
    }

    public Apple(T info) {
        this.info = info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public static void main(String[] args) {
        Apple<String> a1 = new Apple<>("aaa");
        System.out.println(a1.getInfo());

        Apple<Double> a2 = new Apple<>(5.67);
        System.out.println(a2.getInfo());
    }
}

