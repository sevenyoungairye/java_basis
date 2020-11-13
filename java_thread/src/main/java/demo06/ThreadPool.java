package demo06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池demo
 * @author echo lovely
 * @date 2020/11/13 15:08
 */

public class ThreadPool {

    public static void main(String[] args) {

        Runnable runnable = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        });

        // 1. 创建服务 创建线程池，大小为10
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 2. 执行
        service.execute(new Thread(runnable));
        service.execute(new Thread(runnable));
        service.execute(new Thread(runnable));
        service.execute(new Thread(runnable));

        // 3. 关闭连接
        service.shutdown();

    }

}
