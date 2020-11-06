package demo04;

/**
 * 插队线程，此线程开启后，会被强制执行完，
 * 其它线程会阻塞（等待）！
 * @author echo lovely
 * @date 2020/11/6 22:23
 */
public class ThreadJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip用户... 我先.." + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin join = new ThreadJoin();
        Thread thread01 = new Thread(join, "01");

        // 开启01线程
        thread01.start();

        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                // 开启join线程, 开启插队模式，main线程阻塞中..
                thread01.join();
            }
            System.out.println("main线程===> " + i);
        }

        /**
         * 执行过程：
         * 远小于200之前，01 线程 和 main线程是交替执行，但到了200时，
         * 01线程会强制抢占资源，执行完后，main线程才跑。
         */
    }
}
