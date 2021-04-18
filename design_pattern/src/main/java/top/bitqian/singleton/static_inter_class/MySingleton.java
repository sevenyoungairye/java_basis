package top.bitqian.singleton.static_inter_class;

/**
 * @author echo lovely
 * @date 2021/4/18 14:58
 * @description
 * <p>
 *     静态内部类实现单例
 * </p>
 */

public class MySingleton {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() ->
                System.out.println(Thread.currentThread().getName() + "\t" + Singleton.getInstance()),
                String.valueOf(i)
            ).start();
        }
    }


    static class Singleton {

        private Singleton() {
            this.init();
            System.out.println("singleton only init once...");
        }

        // 使用静态内部类的方式创建对象, 这个类只会在使用时加载
        // 而且这个类是基于类加载机制, 线程安全。
        private static final class SingletonInstance {
            private static final Singleton INSTANCE = new Singleton();
        }

        // 对外暴露 获取当前对象的单例
        public static Singleton getInstance() {
            return SingletonInstance.INSTANCE;
        }

        void init() {
            System.out.println("created... do sth...");
        }

    }

}
