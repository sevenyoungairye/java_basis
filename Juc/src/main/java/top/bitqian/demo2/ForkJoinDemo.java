package top.bitqian.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支合并框架
 * 计算1-100以内的加法
 * 递归完成任务 线程池
 * @author echo lovely
 * @date 2021/2/22 11:57
 */

class MyTask extends RecursiveTask<Integer> {

    private static final Integer ADJUST_VALUE = 10;

    private final int start;

    private final int end;

    private int result;

    public MyTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if ((end - start) <= ADJUST_VALUE) {
            for (int i = start; i <= end; i++) {
                result += i;
            }
        } else {
            // 计算 大于10的
            int middle = (start + end) / 2;
            // 拆分为第一个任务
            MyTask t1 = new MyTask(start, middle);
            // 第二哥任务
            MyTask t2 = new MyTask(middle + 1, end);

            // 递归调用
            t1.fork();
            t2.fork();

            result = t1.join() + t2.join();
        }

        return result;
    }

}

public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        MyTask myTask = new MyTask(1, 100);

        ForkJoinTask<Integer> forkJoinRes = forkJoinPool.submit(myTask);

        System.out.println(forkJoinRes.get());

        forkJoinPool.shutdown();

    }

}
