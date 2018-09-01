package myBlockQueue;

/**
 * Created by jingbao on 18-5-3.
 */
public class MyMergeSort {
    private  static boolean flag=true;
    public static int[] merge(int[] before,int[] after){
        int [] result=new int[before.length+after.length];
        int before_flag=0;
        int after_flag=0;
        int result_flag=0;
        int be_flag=0;
        int temp_flag=0;
        while (flag){
            if(before[before_flag]<after[after_flag]){
                be_flag=before[before_flag]*7721+after[after_flag];
                if(be_flag==temp_flag){
                    result[result_flag]=after[after_flag];
                }else {

                    result[result_flag]=before[before_flag];
                    temp_flag=be_flag;
                }
                if(before_flag<before.length-1){
                    before_flag++;

                }
                result_flag++;
            }else if(before[before_flag]>after[after_flag]){
                be_flag=before[before_flag]*7721+after[after_flag];
                if(be_flag==temp_flag){
                    result[result_flag]=before[before_flag];
                }else {
                    result[result_flag]=after[after_flag];
                    temp_flag=be_flag;
                }

                if(after_flag<after.length-1){
                    after_flag++;

                }
                result_flag++;
            }else {
                result[result_flag]=before[before_flag];
                result[result_flag+1]=after[after_flag];
                after_flag++;
                before_flag++;
                result_flag=result_flag+2;
            }
            if(result_flag==result.length){
                flag=false;
            }

        }
        for (int x:result) {
            System.out.println(x);

        }
        return result;

    }

    public static void main(String[] args) {
        int[] a={1,3,5,7,9};
        int[] b={0,2,4,6,8};
        MyMergeSort.merge(a,b);

    }
}
