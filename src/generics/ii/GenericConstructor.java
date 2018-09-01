package generics.ii;

class Foo {
    public<T>  Foo(T t) {

        System.out.println(t);
    }
}

public class GenericConstructor {
    public static void main(String[] args) {
        Foo f=new Foo("aaa");
        new Foo(200);
        Foo f1=new <String> Foo("aaa");
//		new <String> Foo(111);
    }
}
