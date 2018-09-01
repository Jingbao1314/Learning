package arithmetic;

/**
 * Created by jingbao on 18-5-17.
 */
public class Test {
    public static void  knapsack (Goods[] goods,Bag bag){
        int value=0;
        int weight=0;
        int temp=0;
        final int GOODS_COUNT=goods.length;
        final int BAG_CAPACITY=bag.getCapacity();
        int[][] list=new int[GOODS_COUNT+1][BAG_CAPACITY+1];
        for(int i=0;i<GOODS_COUNT;i++){
            for(int j=0;j<BAG_CAPACITY+1;j++){

                weight=goods[i].getWeight();
                value=goods[i].getValue();
                if(weight>j){
                    if(i>0){
                        list[i][j]=list[i-1][j];
                    }else {
                        list[i][j]=0;
                    }
                }else{

                    if(i>0){
                        temp=j-weight;
                        System.out.println(goods[i].getValue());
                        list[i][j]=goods[i].getValue()+list[i-1][temp];
                        if(value>list[i-1][j]){
                            list[i][j]=value;
                        }else {
                            list[i][j]=list[i-1][j];
                        }
                    }else{
                        if(j>0){
                            list[i][j]=list[i][j-1];
                        }else{
                            list[i][j]=0;
                        }

                    }
//                }else{
//                    temp=j-weight;
//                    //System.out.println(goods[i].getValue());
//                    value=goods[i].getValue()+list[i][temp];
//                    if(i>0){
//                        if(value>list[i-1][j]){
//                            list[i][j]=value;
//                        }else {
//                            list[i][j]=list[i-1][j];
//                        }
//                    }
                }

            }
        }
        for(int m=0;m<GOODS_COUNT;m++){
            for(int n=0;n<BAG_CAPACITY+1;n++){
                if(n==BAG_CAPACITY){
                    System.out.println(list[m][n]);
                }else {
                    System.out.print(list[m][n]+"|");
                }
            }
        }

    }

    public static void main(String[] args) {
        Goods aa=new Goods(0,0);
        Goods a=new Goods(4,3);
        Goods b=new Goods(5,4);
        Goods c=new Goods(10,7);
        Goods d=new Goods(11,8);
        Goods e=new Goods(13,9);
        Goods[] list={aa,a,b,c,d,e};
        Bag bag=new Bag(17);
        Test.knapsack(list,bag);
    }
}
