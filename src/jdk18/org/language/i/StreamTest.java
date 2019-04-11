package jdk18.org.language.i;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by andilyliao on 16-8-23.
 */
public class StreamTest {
    public static void main(String[] args) {
//        List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        System.out.println("sum is:"+nums.stream().filter(num -> num != null).
//                distinct().mapToInt(num -> num * 2).
//                peek(System.out::println).skip(2).limit(4).sum());

//
//        List<Integer> nums1 = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        List<Integer> numsWithoutNull = nums1.stream().filter(num -> num != null).distinct().
//// collect方法的三个参数，都是lambda形式的函数
//// 第一个函数生成一个新的ArrayList实例；
//// 第二个函数接受两个参数，第一个是前面生成的ArrayList对象，二个是stream中包含的元素，函数体就是把stream中的元素加入ArrayList对象中。第二个函数被反复调用直到原stream的元素被消费完毕；
//// 第三个函数也是接受两个参数，这两个都是ArrayList类型的，函数体就是把第二个ArrayList全部加入到第一个中；
//        collect(() -> new ArrayList<Integer>(),
//        (list, item) -> list.add(item),
//        (list1, list2) -> list1.addAll(list2));
//        numsWithoutNull.stream().forEach((e)-> System.out.println(e));
//
//        numsWithoutNull = nums.stream().filter(num -> num != null).
//        collect(Collectors.toList());
//        numsWithoutNull.stream().forEach((e)-> System.out.println(e));

//        List<Integer> together = Stream.of(asList(1, 2),asList(3, 4)).flatMap(numbers -> numbers.stream()).collect(toList());
//        together.stream().forEach((e)-> System.out.println(e));
//        count("fdttyuyuffghjrtrrt");

//
//        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) ->sum + item).get());

//        List<Integer> ints1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        System.out.println("ints sum is:" + ints1.stream().reduce(10, (sum, item) -> sum + item));
//
//        List<Integer> ints2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        System.out.println("ints sum is:" + ints2.stream().count());

//        List<Integer> ints3 = Arrays.asList(1,2,3,4,5,6,7,8,9,1000);
//        System.out.println(ints3.stream().allMatch(item -> item < 100));
//        ints3.stream().max((o1, o2) -> o1.compareTo(o2)).ifPresent(System.out::println);
    }


    public static void count(String world){
        int i=-1;
        List<String> list=new ArrayList<>();
        while (i++<world.length()-1){
            list.add(world.substring(i,i+1));
        }
//        list.forEach(n-> System.out.println(n));
        List l=list.stream().map((n)->  n+"1").collect(toList());
        reduce(l);

    }

    public static void reduce(List<String> list){
        Map<String,Integer> map=new HashMap<>();
        for (String world:list) {
            String key=world.substring(0,1);
            int value= Integer.parseInt(world.substring(1,2));
            if(map.isEmpty()){
                map.put(key,value);

            }else {
                boolean flag=exits(key, map.keySet());
                if(flag){
                    int values=map.get(key);
                    map.put(key,value+values);
                }else {
                    map.put(key,value);
                }
            }
        }
        Set set=map.keySet();
        set.forEach((n)-> System.out.println(n+":"+map.get(n)));

    }

    public static boolean exits(String key,Set set){
        List<String> filtered = (List<String>) set.stream().filter((n)->n
                .equals(key)).collect(Collectors.toList());
        if(filtered.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}


