package demo01;

/**
 * 多线程的并发问题 抢票
 * @author echo lovely
 * @date 2020/11/2 21:41
 */
public class TestThread4 implements Runnable {

    // 20张票
    private int ticketNum = 10;

    @Override
    public void run() {

        while (true) {

            if (ticketNum <= 0)
                break;


            try {
                // 为了暴露线程在抢占一个资源时，同步问题，睡两毫秒
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "抢了第" + ticketNum -- +  "张票！");
        }

    }

    public static void main(String[] args) {
        // 多个线程对一个资源
        TestThread4 source = new TestThread4();

        new Thread(source, "线程AAA").start();
        new Thread(source, "线程BBB").start();
        new Thread(source, "线程CCC").start();

    }


}
