package generics.ii_2;

import java.util.ArrayList;
import java.util.List;

public class ArrayErr {
    public static void main(String[] args) {
        Integer[] ia = new Integer[5];
        Number[] na = ia;

        List<Integer> iList = new ArrayList<>();

        // 下面代码导致编译错误
//        List<Number> nList = iList;
        List<? extends Number> nList = iList;
    }
}
