package generics.ii;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class X{
    public static<T>  T copy() {
        T last = (T) "ssfsf";
        return last;
    }

}

public class MyUtils<U> {
    // 下面dest集合元素类型必须与src集合元素类型相同，或是其父类
    public  U xxx(Collection<? super U> dest, U u){
        U u1=null;
        return u1;
    }
    public<U1> U1 xxx(Collection<? super U1> dest, U1 u, String a){
        U1 u1=null;
        return u1;
    }
    public static <T> T copy(Collection<? super T> dest
            , Collection<T> src) {
        T last = null;
        for (T ele : src) {
            last = ele;
            dest.add(ele);
        }
        return last;
    }
    public static<T>  T copy() {
        T last = null;
        return last;
    }

    public static void main(String[] args) {
        String s=X.copy();
        System.out.println(s);
        List<Number> ln = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(5);
        // 此处可准确的知道最后一个被复制的元素是Integer类型
        // 与src集合元素的类型相同
        Integer last = copy(ln, li);    // ①
        System.out.println(ln);
        if(X.copy() instanceof String){
            System.out.println("TRUE");
        }
    }
}