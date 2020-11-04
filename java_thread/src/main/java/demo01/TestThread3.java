package demo01;

/**
 * 线程实现方式2 实现接口
 * @author echo lovely
 * @date 2020/11/2 21:31
 */
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("学习线程========>" + i);
        }
    }

    public static void main(String[] args) {
        TestThread3 thread3 = new TestThread3();

        // 1条线程
        new Thread(thread3).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("main方法" + i);
        }

    }
}
