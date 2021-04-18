package top.bitqian.singleton.double_check;

/**
 * @author echo lovely
 * @date 2021/4/18 11:53
 * @description
 * <p>
 *     双重检查, 即安全, 又满足懒加载
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

        private Singleton() {}

        // volatile让线程的修改立即通知到其它线程, 保证数据一致
        private static volatile Singleton INSTANCE;

        public static Singleton getInstance() {
            if (INSTANCE == null) {
                // 这里只能进来一个线程 只会锁一次
                synchronized (Singleton.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new Singleton();
                    }
                }
            }
            return INSTANCE;
        }

    }

}
