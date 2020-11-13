package demo06;

/**
 * 生产者消费者 问题解决 信号灯
 * @author echo lovely
 * @date 2020/11/13 14:46
 */

public class TestPc2 {

    public static void main(String[] args) {

        Tv tv = new Tv();

        new Player(tv).start();
        new Watcher(tv).start();
    }
}

// 生产者 演员
class Player extends Thread {

    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        tv.play("xxx.. love~");
    }
}

// 消费者 观众
class Watcher extends Thread {

    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        tv.watch();
    }
}

// 产品 节目
class Tv {

    // 1. 演员表演，观众等待
    // 2. 观众观看，演员等待

    String show; // 表演的节目

    boolean flag = true;

    // 表演
    public synchronized void play(String show) {

        // 演员等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 唤醒观众
        this.notifyAll();

        // 节目
        this.show = show;
        System.out.println("演员表演..." + show);

        this.flag = !flag;
    }


    // 观看
    public synchronized void watch() {

        if (flag) {
            // 等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("观看了 " + show);

        // 通知表演者表演
        this.notifyAll();

        this.flag = !flag;
    }


}
