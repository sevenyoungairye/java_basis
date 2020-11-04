package demo01;

/**
 * 多线程模拟龟兔赛跑
 * @author echo lovely
 * @date 2020/11/2 22:19
 */
public class Race implements Runnable {

    // 一个winner
    static String winner;

    @Override
    public void run() {

        for (int i = 1; i < 101; i++) {

            String threadName = Thread.currentThread().getName();

            // 兔子每隔30ms休息10ms钟
            if ("兔子".equals(threadName) && i % 30 == 0) {
                try {
                    // 休息10ms
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(threadName + "跑了 ->" + i + "步。");

            if (isArrival(i)) {
                break;
            }

        }

    }

    public Boolean isArrival(int steps) {
        // 到达终点
        if (winner != null) {
            return true;
        }

        // 跑完了一百步~
        if (steps >= 100) {
            String name = Thread.currentThread().getName();
            winner = name;
            System.out.println(winner + "已经到达了终点~ (￣y▽,￣)╭ ");
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
