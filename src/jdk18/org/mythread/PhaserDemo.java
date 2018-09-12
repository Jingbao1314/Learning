package jdk18.org.mythread;

import java.io.IOException;
import java.util.concurrent.Phaser;

/**
 * Created by jingbao on 18-9-9.
 */
public class PhaserDemo {
    public static void main(String[] args) throws IOException {
        int parties = 3;
        int phases = 4;
        final Phaser phaser = new Phaser(parties) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("====== Phase : " + phase + " ======");
                return registeredParties == 0;
            }
        };
        for(int i = 0; i < parties; i++) {
            int threadId = i;
            Thread thread = new Thread(() -> {
                for(int phase = 0; phase < phases; phase++) {
                    System.out.println(String.format("Thread %s, phase %s", threadId, phase));
                    phaser.arriveAndAwaitAdvance();//
                }
            });
            thread.start();
        }

    }
//    Thread 0, phase 0
//            ====== Phase : 0 ======
//    Thread 0, phase 1
//            ====== Phase : 1 ======
//    Thread 0, phase 2
//            ====== Phase : 2 ======
//    Thread 0, phase 3
//            ====== Phase : 3 ======

}

