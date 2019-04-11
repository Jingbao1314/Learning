package webtest;

import net.openhft.affinity.Affinity;
import net.openhft.affinity.AffinityLock;
import net.openhft.affinity.AffinityStrategies;
import net.openhft.affinity.CpuLayout;

import static net.openhft.affinity.AffinityStrategies.DIFFERENT_CORE;
import static net.openhft.affinity.AffinityStrategies.DIFFERENT_SOCKET;

// -Djava.library.path=/disk/test/iotest/lib
public class MyAffinityTest {
    public static void main(String... args) throws InterruptedException {
        CpuLayout cpu= AffinityLock.cpuLayout();
        System.out.println("cpus: "+cpu.cpus());
        System.out.println("sockets: "+cpu.sockets());
        System.out.println("coresPerSocket: "+cpu.coresPerSocket());
        System.out.println("threadsPerCore: "+cpu.threadsPerCore());
//
//        AffinityLock al = AffinityLock.acquireLock();
        System.out.println("======================");
        System.out.println(Affinity.getCpu());
        System.out.println("======================");
//        try {
//            AffinityLock readerLock = al.acquireLock(DIFFERENT_SOCKET, DIFFERENT_CORE);
//            new Thread(new SleepRunnable(readerLock, false), "reader").start();
//
//         AffinityLock writerLock = readerLock.acquireLock(AffinityStrategies.SAME_CORE);
//            new Thread(new SleepRunnable(writerLock, false), "writer").start();
//
//            Thread.sleep(200);
//        } finally {
//            al.release();
//        }
//        System.out.println("---------------------------------------------------");
//
//        al = AffinityLock.acquireCore(false);
//        new Thread(new SleepRunnable(al, true), "engine").start();
//        Thread.sleep(200);

        new Thread(new SleepRunnable1(), "xxx").start();

//        Thread.sleep(200);
//        System.out.println("\nThe assignment of CPUs is\n" + AffinityLock.dumpLocks());

    }

    static class SleepRunnable implements Runnable {
        private final AffinityLock affinityLock;
        private final boolean wholeCore;

        SleepRunnable(AffinityLock affinityLock, boolean wholeCore) {
            this.affinityLock = affinityLock;
            this.wholeCore = wholeCore;
        }

        public void run() {
            affinityLock.bind(wholeCore);
            System.out.println(Affinity.getCpu());
            while(true);
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//            } finally {
//                affinityLock.release();
//            }
        }
    }
    static class SleepRunnable1 implements Runnable {
        @Override
        public void run() {
            Affinity.setAffinity(0);//亲和第1个cpu
            while(true){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Affinity.getCpu());
            }
        }
    }
}
