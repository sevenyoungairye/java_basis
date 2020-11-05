package demo04;

/**
 * 线程生命周期 之线程停止
 * @author echo lovely
 * @date 2020/11/5 21:39
 */
public class ThreadLife01 {

    // 通过标记的方法让线程停止
    private static boolean flag = true;

    public static void main(String[] args) {

        Runnable runnable = () -> {

            int i = 0;

            while (flag)
                System.out.println("runnable 线程进行中..." + i ++);

        };

        // 开启了一条线程
        new Thread(runnable).start();


        for (int i = 0; i < 1000; i++) {

            System.out.println("main线程" + i);

            if (i == 900) {

                stop();
                System.out.println("runnable 线程停止了===> shutdown");
            }
        }
    }

    static void stop() {
        flag = false;
    }

}
