package top.lel.design.pattern.singleton.enums;

/**
 * @author echo lovely
 * @date 2021/4/18 15:30
 * @description
 * <p>
 *     enum 枚举实现单例
 * </p>
 */

public class EnumSingleton {

    public static void main(String[] args) {

        MySingleton my = MySingleton.ENUM_SINGLETON;
        MySingleton my1 = MySingleton.ENUM_SINGLETON;
        System.out.println(my);
        System.out.println(my1);

        for (int i = 0; i < 1000; i++) {
            new Thread(
                () -> System.out.println(Thread.currentThread().getName() + "\t" +
                MySingleton.ENUM_SINGLETON.getInstance()), String.valueOf(i)
            ).start();
        }

    }

    // private constructor
    private EnumSingleton() {
        this.init();
    }

    public enum MySingleton {
        // 能防止反序列化重新创建新的对象
        ENUM_SINGLETON;

        private final EnumSingleton instance;

        MySingleton() {
            instance = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return instance;
        }
    }

    void init() {
        System.out.println("create once..");
    }
}
