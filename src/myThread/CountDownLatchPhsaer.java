package myThread;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingbao on 18-4-14.
 */
public class CountDownLatchPhsaer {

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser=new Phaser(1);
        for (int i=0;i<3;i++){
            new Mythread((char)(i+97),phaser).start();
        }
        TimeUnit.SECONDS.sleep(3);

        phaser.arrive();
        System.out.println("ok");




    }
}
class Mythread extends Thread{
    private char c;
    private Phaser phaser;
    public Mythread (char c,Phaser phaser){
        this.c=c;
        this.phaser=phaser;
    }
    public void run(){
        phaser.awaitAdvance(phaser.getPhase());
       // System.out.println(phaser.getParent());
        for(int i=0;i<100;i++){
            System.out.println(c+" ");
            if(i%10==9){
                System.out.println();
            }
        }
    }
}

