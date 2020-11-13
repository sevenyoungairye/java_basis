package advanced;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * @author echo lovely
 * @date 2020/11/13 09:15
 */

public class TestLock {

    public static void main(String[] args) {

        // synchronized 和 Lock
        // 1. lock 是显式锁（需要手动开启和关闭），synchronized是隐式锁，出了作用域自动释放
        // 2. lock只有代码块锁 synchronized有代码块和方法锁
        // 3. 使用lock锁，jvm将花费较少时间调度线程，性能更好，具有更好的扩展性，子类多。
        // 4. 使用顺序： Lock > 同步代码块（局部） > 同步方法

        Ticket ticket = new Ticket();

        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }

}

class Ticket implements Runnable {

    // 10 张票
    private int ticketNum = 10;

    // 可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

       buyTicket();

    }

    void buyTicket() {

        try {
            lock.lock(); // 加锁
            while (true) {
                if (ticketNum <= 0) {
                    break;
                } else {
                    // 睡一秒，线程抢票时
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t ticket num: " + ticketNum --);
                }
            }
        } finally {
            lock.unlock(); // 释放锁
        }

    }


}
