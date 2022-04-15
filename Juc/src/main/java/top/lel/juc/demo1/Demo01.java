package top.lel.juc.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 企业级的多线程代码
 * 在高内聚低耦合情况下 多线程 操作 资源类
 * @author echo lovely
 * @date 2021/2/15 13:08
 */

class Ticket {

    private int num = 30;

    Lock lock = new ReentrantLock();

    void sale() {

        lock.lock();

        try {
            if (this.num > 0)
                System.out.println(Thread.currentThread().getName() + " 当前票数: " + this.num -- + "\t还剩下票数: " + num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}

public class Demo01 {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(() -> {

            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }

        } , "A").start();

        new Thread(() -> {

            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }

        } , "B").start();

        new Thread(() -> {

            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }

        } , "C").start();

    }

    void do1() {
        Ticket ticket = new Ticket();
        new MyThread(ticket, "a").start();
        new MyThread(ticket, "b").start();
        new MyThread(ticket, "c").start();
    }

}

class MyThread extends Thread {

    private final Ticket ticket;

    public MyThread(Ticket ticket, String name) {
        super(name);
        this.ticket = ticket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            ticket.sale();
        }
    }
}
