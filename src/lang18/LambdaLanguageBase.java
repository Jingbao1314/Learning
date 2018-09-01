package lang18;

import java.util.Arrays;
import java.util.function.*;

/**
 * Created by andilyliao on 18-8-26.
 */
class User{
    public static User create(Supplier<User> s){
        return s.get();
    }
    public String toString(){
        return "My User";
    }
}
public class LambdaLanguageBase {
    public static void main(String[] args) {
//        Function<T, R>
//        T：入参类型，R：出参类型
//        调用方法：R apply(T t);
        Function<Integer,Integer> f=p->p+1;
        f.apply(1);
        Arrays.asList(1,2,3).stream().map(f).forEach(System.out::println);
        System.out.println("======================================================\n");
//        BiFunction<T, U, R>
//        T,U：入参类型，R：出参类型
//        调用方法：R apply(T t);
        BiFunction<Integer,Integer,Integer> b=(x,y)->x+y;
        BinaryOperator<Integer> b1= (x,y)->x+y;//BinaryOperator是BiFunction的子类
        b.apply(1,2);
        System.out.println(Arrays.asList(1,2,3).stream().reduce(b1).get());
        System.out.println("======================================================\n");
//        Consumer<T>
//        T：入参类型；没有出参
//        调用方法：void accept(T t);
        Consumer<Integer> c= p -> System.out.println(p);
        c.accept(1);
        Arrays.asList(1,2,3).stream().forEach(c);
        System.out.println("======================================================\n");
//        Predicate<T>
//        T：入参类型；出参类型是Boolean
//        调用方法：boolean test(T t);
        Predicate<Integer> pr = p -> p >2;
        pr.test(10);
        Arrays.asList(1,2,3,4,5).stream().filter(pr).forEach(System.out::println);
        System.out.println("======================================================\n");
//        Supplier<T>
//        T：出参类型；没有入参
//        调用方法：T get();

        Supplier<User> s= () -> new User();
        s.get();
        System.out.println(User.create(User::new));
    }
}
