package demo04;

/**
 * 礼让线程 两个线程 a和b
 * a调度的时候从cpu中跑出来，然后a，b同时在外面等着被调度
 * 礼让是否成功 看cpu的心情
 * @author echo lovely
 * @date 2020/11/6 22:14
 */
public class ThreadYield implements Runnable {

    public static void main(String[] args) {
        ThreadYield yield = new ThreadYield();

        new Thread(yield, "a线程").start();
        new Thread(yield, "b线程").start();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "调度前");

        Thread.yield(); // 线程礼让 可能礼让失败，当前线程就会跑完

        System.out.println(Thread.currentThread().getName() + "调度后");
    }
}
