package top.lel.juc.demo1;

import java.util.concurrent.CountDownLatch;

/**
 * @author echo lovely
 * @date 2021/2/18 12:00
 */

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        solution();

        // closeDoor();

    }

    private static void solution() throws InterruptedException {
        // 当指定的线程运行完 主线程开始跑
        CountDownLatch cdl = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(
                    () -> {
                        System.out.println(Thread.currentThread().getName() + "\t" + "left the classroom..");
                        cdl.countDown();
                    },
                    String.valueOf(i)).start();
        }

        cdl.await();

        System.out.println(Thread.currentThread().getName() + "\t close the door...");
    }

    private static void closeDoor() {
        for (int i = 0; i < 6; i++) {
            new Thread(
                    () -> System.out.println(Thread.currentThread().getName() + "\t" + "left the classroom.."),
                    String.valueOf(i)).start();
        }

        System.out.println(Thread.currentThread().getName() + "\t close the door...");
    }

}
