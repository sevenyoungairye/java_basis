package top.lel.juc.demo1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号灯法
 * 资源的抢占 与 释放
 * @author echo lovely
 * @date 2021/2/19 09:23
 */

public class SemaphoreDemo {


    public static void main(String[] args) {

        // 3 个停车位
        Semaphore semaphore = new Semaphore(3);


        for (int i = 0; i < 6; i++) {

            new Thread(() -> {
                try {
                    // 获取到资源
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() + "\t抢占到了车位");

                    // 当前线程停止车位
                    TimeUnit.SECONDS.sleep(3);

                    System.out.println(Thread.currentThread().getName() + "\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 当前线程释放资源
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }

    }

}
