package top.bitqian.singleton.hungry;

/**
 * @author echo lovely
 * @date 2021/4/18 10:40
 * @description
 * <p>
 *     饿汉式: 静态代码块
 *     安全, 耗内存, 不满足懒加载
 * </p>
 */

public class StaticCodeBlockSingleton {

    public static void main(String[] args) {
        // true
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
    }

    static class Singleton {

        private Singleton() {}

        private static final Singleton INSTANCE;

        static {
            INSTANCE = new Singleton();
        }

        public static Singleton getInstance() {
            return INSTANCE;
        }

    }

}
