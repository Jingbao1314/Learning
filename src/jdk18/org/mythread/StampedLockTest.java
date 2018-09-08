package jdk18.org.mythread;

/**
 * Created by andilyliao on 16-8-23.
 */

import java.util.concurrent.locks.StampedLock;
//
public class StampedLockTest {
    //
    private double x, y;
    private final StampedLock sl = new StampedLock();
    //
    double distanceFromOrigin() { // A read-only method
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        System.out.println(currentX+"    "+currentY);
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
    //
    void moveIfAtOrigin(double newX, double newY) { // upgrade//////
        // Could instead start with optimistic, not read mode
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = sl.tryConvertToWriteLock(stamp); //升级为写锁
                if (ws != 0L) { //upgrade成功
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
    //
    public static void main(String[] args) {
        StampedLockTest slt = new StampedLockTest();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    slt.distanceFromOrigin();
                }
            }
        }.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        slt.moveIfAtOrigin(10, 20);
    }
}
