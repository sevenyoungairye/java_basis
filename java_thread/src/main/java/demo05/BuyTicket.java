package demo05;

/**
 * 排队 + 锁（同时操作一个资源，只能一个线程在某个时间下，操作一个资源）
 * @author echo lovely
 * @date 2020/11/8 22:04
 */
public class BuyTicket {

    public static void main(String[] args) {

        // 抢票
        Ticket ticket = new Ticket();

        // 三人抢十张票
        new Thread(ticket, "小明").start();
        new Thread(ticket, "小红").start();
        new Thread(ticket, "小丽").start();

        // 问题出现：
        // 两个人可能抢到同一张票，抢到的票可能为0或者负数

    }

}

class Ticket implements Runnable {

    private int ticketNum = 10;

    private boolean flag = true;

    @Override
    public void run() {

        try {
            while (flag) {
                buyTicket();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 买票
    void buyTicket() throws InterruptedException {

        if (ticketNum <= 0) {
            flag = false;
            return;
        }

        // 休眠1ms
        Thread.sleep(100);

        System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- + "张票");
    }
}
