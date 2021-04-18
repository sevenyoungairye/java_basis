package top.bitqian.singleton.lazy;

/**
 * @author echo lovely
 * @date 2021/4/18 11:03
 * @description
 * <p>
 *     懒加载 线程不安全 只适合单线程
 * </p>
 */

public class NotSafeSingleton {

    public static void main(String[] args) {

        for (int i = 0; i < 40; i++) {
            new Thread(() ->
                System.out.println(Thread.currentThread().getName() + "\t" + Singleton.getInstance()),
                String.valueOf(i)
            ).start();
        }

    }


    static class Singleton {

        private Singleton() {}

        private static Singleton singleton;

        public static Singleton getInstance() {
            // 没有就创建, 有就返回
            // 多线程下, 多个线程如果同时进if, 则会创建多个实例
            if (singleton == null) {
                singleton = new Singleton();
                return singleton;
            }

            return singleton;
        }

    }

}
