package demo06;

/**
 * 死锁.. 两个线程以上
 * 多个线程互相抱着对方的资源，形成僵持
 * @author echo lovely
 * @date 2020/11/12 08:50
 */

public class DeadLock {

    public static void main(String[] args) {

        new Makeup(0, "小丽").start();
        new Makeup(1, "小美").start();

    }

}
// a face reflect
class Monitor {

}

// mouse to be red
class Lipstick {

}

class Makeup extends Thread {

    // 需要的资源只有一份
    static final Monitor monitor = new Monitor();

    static final Lipstick lipstick = new Lipstick();

    int choice;
    String girlName;

    public Makeup(int choice, String girlName) {
        super(girlName);
        this.choice = choice;
        this.girlName = girlName;
    }

    // run
    @Override
    public void run() {

        makeup();
    }

    void makeup() {

        if (choice == 0) {
            synchronized (monitor) { // 占用镜子的锁

                System.out.println("girl获得镜子的锁..." + this.girlName);
            }

            // 解决： 不锁住对方需要的对象
            synchronized (lipstick) {
                System.out.println("girl获得口红的锁..." + this.girlName);
            }
        } else {
            synchronized (lipstick) { // 占用了口红的锁

                System.out.println("girl 获得口红的锁..." + this.girlName);
            }

            synchronized (monitor) {
                System.out.println("girl 获得镜子的锁..." + this.girlName);

            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*
    // 死锁.. 线程1 抢夺线程2的资源。线程2来抢夺线程1的资源

        if (choice == 0) {
            synchronized (monitor) { // 占用镜子的锁

                System.out.println("girl获得镜子的锁..." + this.girlName);

                synchronized (lipstick) {
                    System.out.println("girl获得口红的锁..." + this.girlName);
                }
            }
        } else {
            synchronized (lipstick) { // 占用了口红的锁

                System.out.println("girl 获得口红的锁..." + this.girlName);

                synchronized (monitor) {
                    System.out.println("girl 获得镜子的锁..." + this.girlName);

                }
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    */

    // 产生死锁的条件
    // 1. 一个资源每次只能被一个进程使用
    // 2. 一个进程因请求资源而阻塞时，对已获得的资源保持不变
    // 3. 进程已获得的资源，在未使用完之前，不能强行剥夺
    // 4， 若干进程形成之间形成一种头尾相接的循环等待资源关系


}
