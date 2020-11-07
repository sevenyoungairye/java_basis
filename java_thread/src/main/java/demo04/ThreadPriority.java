package demo04;

/**
 * 线程优先级, 优先级越高，不一定先调度。
 * @author echo lovely
 * @date 2020/11/7 22:20
 */
public class ThreadPriority {

    // 线程体
    static Runnable runnable = () ->
            System.out.println(Thread.currentThread().getName()
                    + "---优先级：" + Thread.currentThread().getPriority());

    public static void main(String[] args) {

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);

        System.out.println(Thread.currentThread().getName() + "--main 线程--"
                + Thread.currentThread().getPriority());

        t1.setPriority(7);
        t1.start();

        t2.setPriority(Thread.NORM_PRIORITY); // 5
        t2.start();

        t3.setPriority(Thread.MIN_PRIORITY); // 1
        t3.start();

        t4.setPriority(4);
        t4.start();

        t5.setPriority(Thread.MAX_PRIORITY); // 10
        t5.start();

    }

}
