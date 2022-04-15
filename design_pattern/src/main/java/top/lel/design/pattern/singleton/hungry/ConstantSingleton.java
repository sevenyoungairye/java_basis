package top.lel.design.pattern.singleton.hungry;

/**
 * @author echo lovely
 * @date 2021/4/18 10:32
 * @description <p>
 *     饿汉式单例: 静态常量
 *     总结: 线程安全, 类加载, 对象就创建。耗内存, 可能用不到, lazy loading isn't satisfy..
 * </p>
 */

public class ConstantSingleton {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }

    static class Singleton {

        private Singleton() {}

        private static final Singleton INSTANCE = new Singleton();

        public static Singleton getInstance() {

            return INSTANCE;
        }

    }

}
