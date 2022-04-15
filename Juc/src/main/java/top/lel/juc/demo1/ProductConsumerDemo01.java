package top.lel.juc.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*等待 唤醒 （生产 通知）
 * 判断 干活 通知
 * 1. 高内聚的情况下 多线程操作同一个资源
 * 2. 判断 干活 通知
 * 3. 防止虚假唤醒 (while 替代if解决)
 *
 * @author echo lovely
 * @date 2021/2/17 11:12
 */

/**
 * thread demo by synchronized keywords
 */
class AirCondition {

    // wait || await
    private int num = 0;

    synchronized void increment() throws InterruptedException {

        while (num != 0) {
            // 等待 不生产
            this.wait();
        }

        num++;

        System.out.println(Thread.currentThread().getName() + "\t" + num);

        // 唤醒其它线程消费
        this.notifyAll();

    }

    synchronized void decrease() throws InterruptedException {

        while (num == 0) {
            // 没有东西 需要等待 不能消费
            this.wait();
        }

        this.num--;

        System.out.println(Thread.currentThread().getName() + "\t" + num);

        // 唤醒生产者生产
        this.notifyAll();

    }

}

/**
 * thread demo by lock
 */
class AirCondition1 {
    // lock -> product or consumer

    private int num = 0;

    // 非公平锁
    private final Lock lock = new ReentrantLock();

    // 用于lock的等待和唤醒 monitor
    private final Condition condition = lock.newCondition();

    void increment() {

        lock.lock();

        try {
            while (num != 0) {
                condition.await();
            }

            num++;

            System.out.println(Thread.currentThread().getName() + "\t" + num);

            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    void decrease() {

        lock.lock();

        try {
            while (num == 0) {
                // 没有可消费 等待
                condition.await();
            }

            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);

            // 唤醒生产者生产
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}

public class ProductConsumerDemo01 {

    public static void main(String[] args) {

        awaitSignal();


        // waitNotify();

    }

    private static void awaitSignal() {
        AirCondition1 condition = new AirCondition1();

        // thread one product
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                condition.increment();

            }
        }, "Rye").start();

        // thread two consumer
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                condition.decrease();
            }
        }, "sevenYoungAiRye").start();

        // thread three product
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                condition.increment();
            }
        }, "hh1").start();

        // thread four consumer
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                condition.decrease();

            }
        }, "hh2").start();
    }

    private static void waitNotify() {
        AirCondition ac = new AirCondition();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ac.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ac.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ac.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    ac.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }

}
