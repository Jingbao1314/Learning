package dijkatra;

import myBlockQueue.FastRankTest;

import java.util.HashMap;

/**
 * Created by jingbao on 18-5-31.
 */
public class Greed {
    public static int flag=0;
    public static int values;
    public static int weigh;
    public static HashMap<Integer,Integer> goods;
    public static HashMap <Float,Integer>goods_price=new HashMap<>();
    public Greed(){
    }
    public  Greed(int values,int weigh,HashMap<Integer,Integer> map){
        this.values=values;
        this.weigh=weigh;
        this.goods=map;

    }
    public static void greed(){
        Integer fleg=0;
        Integer valuesFlag=0;
        int i=0;
        float []price=new float[goods.size()];
        for (Integer map:goods.keySet()) {
            System.out.println(map);

            if (fleg != map||valuesFlag!=goods.get(map)) {
                price[i] = goods.get(map) / map;
                goods_price.put(price[i], map);
                System.out.println(price[i] + "**------------------");

            }
            fleg=map;
            valuesFlag=goods.get(map);

            i++;
        }
        FastRankTest fast=new FastRankTest();
        price=fast.fRank(price);
        for (int j=0;j<price.length;j++){
            Integer key=goods_price.get(price[j]);
            Integer value=goods.get(key);
            System.out.println(key+"*******"+value+"***"+price[j]);
            if(key>weigh){
                flag=j;
                break;

            }
            values=values+value;
            weigh=weigh-key;
            flag=j;
        }
        values= (int) (values+(int)weigh*price[flag]);
        System.out.println(values);




    }


    public static void main(String[] args) {
        HashMap<Integer,Integer> goods=new HashMap<>();
        goods.put(2,2);
        goods.put(3,9);
        goods.put(1,3);
        goods.put(4,16);

        Greed greed=new Greed(0,10,goods);
        greed.greed();

    }

}
