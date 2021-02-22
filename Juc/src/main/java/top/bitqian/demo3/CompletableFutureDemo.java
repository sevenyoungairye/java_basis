package top.bitqian.demo3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步调用
 * @author echo lovely
 * @date 2021/2/22 16:11
 */

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        voidComplete();

        returnComplete();


    }

    private static void returnComplete() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {

            System.out.println("异步回调~~~" + Thread.currentThread().getName());
            return 1024;
        });

        // 可对上面的结果进行get

        // 调用完成 do sth...
        System.out.println(completableFuture2.whenComplete((res, exp) -> {

            System.out.println("调用成功！！！" + res);

            System.out.println("调用失败消息!!!" + exp);
        }).exceptionally(e -> {
            System.out.println("异常了" + e.getMessage());
            return 4444;
        }).get());
    }

    private static void voidComplete() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println("run it \t" + Thread.currentThread().getName());
            System.out.println("runnable... 没有返回值");
        });

        // 调用异步方法
        completableFuture1.get();
    }

}
