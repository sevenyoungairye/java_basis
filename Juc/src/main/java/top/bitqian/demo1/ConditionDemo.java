package top.bitqian.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目:
 *      三个线程之间 打印 5 10 15 次。轮询打印10次。
 * @author echo lovely
 * @date 2021/2/17 18:43
 */

class ShareData {

    private int num = 1; // 1 A, 2 B, 3 C

    private final Lock lock = new ReentrantLock();

    // 三把钥匙 用于解锁
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    void print5() {

        try {
            lock.lock();

            // 1. 判断
            while (num != 1) {
                // 等待
                c1.await();
            }

            // 2. 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 3. 通知
            num = 2;
            // 唤醒第二个线程
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void print10() {
        try {
            lock.lock();

            // 线程2 等待
            while (num != 2) {
                c2.await();
            }

            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 通知三个线程
            num = 3;

            c3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void print15() {

        try {
            lock.lock();

            while (num != 3) {
                c3.await();
            }

            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 通知线程1
            num = 1;
            c1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}

public class ConditionDemo {

    public static void main(String[] args) {

        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print15();
            }
        }, "C").start();

    }

}
