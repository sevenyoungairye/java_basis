package top.bitqian.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程的实现方式 实现callable接口
 * @author echo lovely
 * @date 2021/2/18 10:28
 */

class MyThreadByCallable implements Callable<String> {
    @Override
    public String call() {
        return "hell callable!";
    }
}

public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        callDemo();

    }

    private static void callDemo() throws InterruptedException, ExecutionException {

        FutureTask<String> futureTask = new FutureTask<>(new MyThreadByCallable());

        // 开启线程
        new Thread(futureTask, "rye").start();

        String res = futureTask.get();

        System.out.println(res);

    }

}
