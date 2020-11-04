package demo03;

/**
 * lambda表达式 进化 involution
 * @author echo lovely
 * @date 2020/11/4 21:59
 */
public class LambdaDemo01 {

    /**
     * 2. 静态内部类
     */
    static class Love02 implements Lover {
        @Override
        public void love() {
            System.out.println("lover02...静态内部类");
        }
    }

    public static void main(String[] args) {

        // 测试
        Lover lover = null;

        /**
         * 3. 局部内部类
         */
        class Love03 implements Lover {
            @Override
            public void love() {
                System.out.println("lover03...局部内部类");
            }
        }

        /**
         * 4. 匿名内部类
         */
        lover = new Lover() {
            public void love() {
                System.out.println("lover04...匿名内部类");
            }
        };

        // lover.love();

        /**
         * 5. 逼格lambda
         */
        lover = () -> {
            System.out.println("lambda el");
        };

        lover.love();

    }


}

interface Lover {
    void love();
}

/**
 * 1. 外部类
 */
class Lover01 implements Lover {
    @Override
    public void love() {
        System.out.println("lover01...外部类");
    }
}
