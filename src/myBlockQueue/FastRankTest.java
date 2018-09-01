package myBlockQueue;

import java.util.Random;

/**
 * Created by jingbao on 18-4-19.
 */
public class FastRankTest {
    private boolean flag=false;
    private boolean flag_lift=false;
    private boolean flag_right=true;
    private int temp=0;
    private int flag_big=0;
    private int flag_small=0;
    private float lTemp=0;
    public int[] rank(int[] list){
        //flag_big=list.length-1;
        for(int i=0;i<list.length;){
            flag_small=i;
            flag_big=list.length-1;
            flag=false;
            flag_right=true;
            flag_lift=false;
            while (flag_small<flag_big){
                //System.out.println("++++++++"+flag_right);
              if(flag_right){
                  System.out.print("reight +");
                  if(list[flag_small]>list[flag_big]){

                      temp=list[flag_big];
                      list[flag_big]=list[flag_small];
                      list[flag_small]=temp;
                      System.out.println(list[flag_big]+"------"+list[flag_small]);
                      if(list[flag_small]<list[flag_big]){
                          flag_right=false;
                          flag_lift=true;
                          flag=true;
                      }

                      flag_big--;
                  }else {
                      flag_big--;

                  }
              }
              if(flag_lift){
                  if(list[flag_small]<list[flag_big]){
                      System.out.print("left");
                      temp=list[flag_big];
                      list[flag_big]=list[flag_small];
                      list[flag_small]=temp;
                      System.out.println(list[flag_big]+"------"+list[flag_small]);

                      if(list[flag_small]>list[flag_big]){
                          flag_right=true;
                          flag_lift=false;
                          flag=true;
                      }
                      flag_small++;
                  }else {
                      flag_small++;
                  }
              }

            }
            System.out.println("end");
            if(flag==true){
            }else {
                i++;
            }

        }
        return list;
    }
    public float[] fRank(float[] list){
        //flag_big=list.length-1;
        for(int i=0;i<list.length;){
            flag_small=i;
            flag_big=list.length-1;
            flag=false;
            flag_right=true;
            flag_lift=false;
            while (flag_small<flag_big){
                //System.out.println("++++++++"+flag_right);
                if(flag_right){
                    if(list[flag_small]>list[flag_big]){

                        lTemp=list[flag_big];
                        list[flag_big]=list[flag_small];
                        list[flag_small]=temp;
                        if(list[flag_small]<list[flag_big]){
                            flag_right=false;
                            flag_lift=true;
                            flag=true;
                        }

                        flag_big--;
                    }else {
                        flag_big--;

                    }
                }
                if(flag_lift){
                    if(list[flag_small]<list[flag_big]){

                        lTemp=list[flag_big];
                        list[flag_big]=list[flag_small];
                        list[flag_small]=temp;


                        if(list[flag_small]>list[flag_big]){
                            flag_right=true;
                            flag_lift=false;
                            flag=true;
                        }
                        flag_small++;
                    }else {
                        flag_small++;
                    }
                }

            }
            if(flag==true){
            }else {
                i++;
            }

        }
        return list;
    }


    public static void main(String[] args) {
        int[] list={1,4,2,3,5};
        new FastRankTest().rank(list);
        for (int result:list) {
            System.out.println(result);

        }

    }

}
