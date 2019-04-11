package jdk18.org.language.i;

import java.util.stream.IntStream;

/**
 * @author jijngbao
 * @date 19-4-11
 */
public class StreamError {
    public static void main(String[] args) {//https://blog.csdn.net/w605283073/article/details/81104844
        //https://blog.csdn.net/jdz199409/article/details/78466180

        int[] values = new int[]{2, 3, 6, 22, 5};

        IntStream range = IntStream.of(values);//错误方式
        int resultSequential = StreamError.sequentialSumOfSquares(range);
        int resultParallel = StreamError.parallelSumOfSquares(range);


//        IntStream seq = IntStream.of(values);//正确方式
//        IntStream par = IntStream.of(values);
//        int resultSequential = StreamError.sequentialSumOfSquares(seq);
//        int resultParallel = StreamError.parallelSumOfSquares(par);



        System.out.println("串行：" + resultSequential + ": 并行 ：" + resultParallel);
    }

    //串行求列表数字的平方和
    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x)
                .sum();
    }

    // 并行流求列表数字的平方和
    public static int parallelSumOfSquares(IntStream range) {
        return range.parallel()
                .map(x -> x * x)
                .sum();
    }

}
