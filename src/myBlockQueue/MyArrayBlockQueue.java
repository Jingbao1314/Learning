package myBlockQueue;

/**
 * Created by jingbao on 18-3-18.
 */
public class MyArrayBlockQueue {
    private volatile int count=0;
    private volatile int num=0;
    private volatile int flag=0;
    private  Object[] queue=null;
    public MyArrayBlockQueue(int count){
        this.count=count;
        queue=new Object[count];
    }
    public synchronized  boolean myOffer(Object data){
       if(num==count){
           return false;
       }else {
           queue[num]=data;
           num++;
       }
       return true;
    }
    public synchronized Object myPoll(){
        Object data=null;
        for(int i=0;i<count-1;i++){
            if(queue[flag]!=null){
                data=queue[flag];
                queue[flag]=null;
                i=count;
                num--;
               if(flag<count-1){
                   flag++;
               }else {
                   flag=0;
               }
            }

        }
        return data;
    }


    public static void main(String[] args) {
        MyArrayBlockQueue x=new MyArrayBlockQueue(3);
        x.myOffer("5");
        x.myOffer("4444");
        x.myOffer("5446");
        System.out.println(x.myPoll());
        System.out.println(x.myPoll());
        System.out.println(x.myPoll());
        System.out.println(x.myPoll());
        x.myOffer("5446");
        System.out.println(x.myPoll());
    }


}
