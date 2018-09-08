package jdk18.org.mythread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * Created by andilyliao on 16-8-23.
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<List<Integer>> exchanger = new Exchanger<>();
        new Consumer(exchanger).start();
        new Producer(exchanger).start();
    }

}

class Producer extends Thread {
    List<Integer> list = new ArrayList<>();
    Exchanger<List<Integer>> exchanger = null;
    public Producer(Exchanger<List<Integer>> exchanger) {
        super();
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        Random rand = new Random();
        for(int i=0; i<10; i++) {
            list.clear();
            list.add(rand.nextInt(10000));
            list.add(rand.nextInt(10000));
            list.add(rand.nextInt(10000));
            list.add(rand.nextInt(10000));
            list.add(rand.nextInt(10000));
            try {
                Thread.sleep(2000);
                System.out.println("333333333");
                list = exchanger.exchange(list);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    List<Integer> list = new ArrayList<>();
    Exchanger<List<Integer>> exchanger = null;
    public Consumer(Exchanger<List<Integer>> exchanger) {
        super();
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            try {
                System.out.println("11111111");
                list = exchanger.exchange(list);
                System.out.println("222222222");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.print(list.get(0)+", ");
            System.out.print(list.get(1)+", ");
            System.out.print(list.get(2)+", ");
            System.out.print(list.get(3)+", ");
            System.out.println(list.get(4)+", ");
        }
    }
}
