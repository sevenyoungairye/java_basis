package top.bitqian.demo2;

import java.util.concurrent.*;

/**
 * 线程池demo
 * @author echo lovely
 * @date 2021/2/20 10:28
 */

public class ThreadPoolDemo01 {

    public static void main(String[] args) {

        // System.out.println(Runtime.getRuntime().availableProcessors());

        // 线程池允许的访问次数(并发) maximumPoolSize + blockQueueSize
        // 最大工作的线程个数: maximumPoolSize
        ExecutorService threadPool  = new ThreadPoolExecutor(
                4,
                6,
                5L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        // java.util.concurrent.RejectedExecutionException
        // 并发数量达到了最大访问次数 默认采用拒绝策略

        try {

            for (int i = 1; i <= 10; i++) {
                // TimeUnit.SECONDS.sleep(1);
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        // initPool();
    }

    private static void initPool() {
        // 1. new 5 个线程 持久 稳定形
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // 2. 线程池 一个线程
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();

        // 3. 缓存线程池 面对蜂拥来的并发
        // ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {

            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            threadPool.execute(() -> System.out.println("线程\t" + Thread.currentThread().getName() + "\t正在受理业务"));
        }

        // close the theadPool
        threadPool.shutdown();
    }

}
