package reg;

class Cache {
    public void run(int[] cache) {
        int a = 0;
        int j = cache.length - 1;
        int k = cache[0];
        boolean flag = true;
        while (flag){
            for (; j > 0; j--) {
                if (k > cache[j]) {
                    int temp = cache[j];
                    cache[j] = k;
                    k = temp;
                    j = j--;
                    System.out.println("AAAAAAA"+k);
                    break;
                }
            }
            System.out.println("XXXXXXXX"+cache[1]);


            int i;
            for (i = 0; i < j; i++) {
                if (k < cache[i]) {
                    int temp = cache[i];
                    cache[i] = k;
                    k = temp;
                    a = i;
                    break;
                }
            }
            System.out.println(a +"-----"+ j);
            System.out.println(cache[0]);//6  4
            System.out.println(cache[1]);//3  3
            System.out.println(cache[2]);//4  6
            System.out.println(cache[3]);//7  7
            System.out.println(cache[4]);//8  8
            if (a == j - 1) {
                flag = false;
            }
        }


    }
}

public class StringReg {
    public static void main(String[] args) {
        int [] cache=new int[6];
        cache[0]=5;
        cache[1]=3;
        cache[2]=4;
        cache[3]=7;
        cache[4]=8;
        cache[5]=6;
        Cache c=new Cache();
        c.run(cache);
//        System.out.println(cache[0]);
//        System.out.println(cache[1]);
//        System.out.println(cache[2]);
//        System.out.println(cache[3]);
//        System.out.println(cache[4]);
    }
}
