package lang18;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by andilyliao on 18-8-26.
 */
class Range{
    public static Stream<Integer> range(int start,int end){
        return range(start,end,1);
    }
    public static Stream<Integer> range(int start,int end,int step){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=start;i<end;i+=step){
            list.add(i);
        }
        return list.stream();
    }
}
public class My99InLine {
    public static void main(String[] args) {
        Range.range(1,10).forEach(n->System.out.println(Range.range(1,n+1).map
                (m->m+"*"+n+"="+n*m+"\t").reduce((x,y)->x+y).get()));
    }
    //Optional
}
