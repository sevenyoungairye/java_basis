package top.bitqian.demo1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列 put take
 * 先进先出
 * @author echo lovely
 * @date 2021/2/19 11:43
 */

public class BlockingQueueDemo {

    public static void main(String[] args) {

        // 初始阻塞队列长度为3
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // Exception in thread "main" java.lang.IllegalStateException: Queue full
        /*blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        blockingQueue.add("d");*/

        // Exception in thread "main" java.util.NoSuchElementException
        // System.out.println(blockingQueue.remove());

        /*try {
            blockingQueue.put("a");
            blockingQueue.put("b");
            blockingQueue.put("c");
            // 下面会阻塞 等待
            // blockingQueue.put("a");
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*try {
            // 队列为空会阻塞
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*System.out.println(blockingQueue.offer("hh"));
        System.out.println(blockingQueue.offer("ee"));
        System.out.println(blockingQueue.offer("gg"));
        // false
        System.out.println(blockingQueue.offer("ff"));*/

        // null
        // System.out.println(blockingQueue.poll());

        try {
            blockingQueue.offer("hh");
            blockingQueue.offer("f");
            blockingQueue.offer("g");
            blockingQueue.offer("hhh", 3L, TimeUnit.SECONDS);

            // 3s后插入不了暂停插入 不会阻塞 hh, f, g
            blockingQueue.forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
