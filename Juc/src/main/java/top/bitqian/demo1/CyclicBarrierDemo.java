package top.bitqian.demo1;

import java.util.concurrent.CyclicBarrier;

/**
 * ++++
 * 优先几个线程通过计数增加的方式来执行 会优先执行 最后执行指定的任务。
 * @author echo lovely
 * @date 2021/2/18 14:36
 */

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        // 线程计数器
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("获取七龙珠, 召唤神龙。"));

        for (int i = 0; i < 7; i++)
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t获取龙珠");

                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();

    }

}
