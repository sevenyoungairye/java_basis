package demo04;

/**
 * 线程的五种状态
 * @author echo lovely
 * @time 2020/11/7 21:30
 */
public class ThreadState {

    /**
     * NEW 尚未启动的线程
     * RUNNABLE 在Java虚拟机中执行的线程
     * BLOCKED 被阻塞等待监视器锁定的线程(其它线程抢夺了，join线程)
     * WAITING 正在等待另一个线程执行特定动作的线程 wait
     * TERMINATED 已退出的线程
     * @param args null
     * @throws InterruptedException exception
     */
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("sleep 5 seconds, i'll sleep~");
        });

        // 获取当前线程的状态
        Thread.State state = thread.getState();
        System.out.println(state);

        // 启动后
        thread.start();

        // 观察启动后的线程
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED) {

            Thread.sleep(100);

            // 打印当前线程的状态
            System.out.println(state);

            // 重新获取线程的状态
            state = thread.getState();
        }

        System.out.println(state);

        System.out.println("thread shutdown...");

        thread.start();// 再次启动会报错，因为线程挂掉了..
    }

}
