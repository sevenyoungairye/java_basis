package demo04;

/**
 * 守护线程，虚拟机不会等待守护线程执行完，用户线程挂掉后，守护线程才挂
 * demo: 日志，内存监控，gc...
 * @author echo lovely
 * @date 2020/11/7 22:45
 */
public class ThreadDaemon {

    public static void main(String[] args) {
        Runnable god = () -> {
            while (true) {
                System.out.println("god bless you!");
            }
        };

        Runnable you = () -> {
            for (int i = 0; i < 36500; i++) {
                System.out.println("you are active..");
            }
            System.out.println("you death!");
        };

        // god
        Thread daemonThread = new Thread(god, "god");
        daemonThread.setDaemon(true); // 设置god为守护线程, 默认情况下为用户线程

        daemonThread.start();

        // you
        Thread threadUsual = new Thread(you, "you");
        threadUsual.start();
    }
}
