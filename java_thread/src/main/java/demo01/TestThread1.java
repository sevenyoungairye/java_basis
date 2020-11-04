package demo01;

/**
 * 线程创建方式1. 继承thread类，重写run方法，调用start开启线程
 * @author echo lovely
 * @date 2020/11/1 22:23
 *
 * 线程开启不一定立即执行，由cpu调度执行
 */
public class TestThread1 extends Thread {
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("run线程" + i);
        }
    }

    public static void main(String[] args) {

        // 线程开启
        new TestThread1().start();

        for (int i = 0; i < 200; i++) {
            System.out.println("main线程" + i);
        }
    }

}
