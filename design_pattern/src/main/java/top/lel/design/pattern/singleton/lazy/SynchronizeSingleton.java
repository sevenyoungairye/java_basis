package top.lel.design.pattern.singleton.lazy;

/**
 * @author echo lovely
 * @date 2021/4/18 11:10
 * @description
 * <p>
 *     懒汉式, 同步代码块, 基于方法同步
 *     安全, 但是效率低下
 * </p>
 */

public class SynchronizeSingleton {

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() ->
                System.out.println(Thread.currentThread().getName() + "\t" + Singleton.getInstance()),
                String.valueOf(i)
            ).start();
        }

    }

    static class Singleton {

        private Singleton() {}

        private static Singleton instance;

        // 整个方法只许一个人进来, 其它线程waiting...
        public static synchronized Singleton getInstance() {

            if (instance != null) {
                return instance;
            }

            instance = new Singleton();

            return instance;
        }

    }

    // 同步方法if块...
    @Deprecated
    static class BadSingleton {

        private BadSingleton() {}

        private static BadSingleton instance;

        public static BadSingleton getInstance() {

            // fixme: 多线程下不安全, 不能用, 多个线程进来
            if (instance == null) {
                synchronized (BadSingleton.class) {
                    instance = new BadSingleton();
                    return instance;
                }
            }

            return instance;
        }
    }

}
