package generics.ii;

public class Apple<T extends Number> {
    T col;

    public static void main(String[] args) {
        Apple apple1=new Apple();
        Apple<Integer> ai = new Apple<Integer>();
        Apple<Double> ad = new Apple<Double>();
        // 下面代码将引起编译异常，下面代码试图把String类型传给T形参
        // 但String不是Number的子类型，所以引发编译错误
//		Apple<String> as = new Apple<>();
    }
}

