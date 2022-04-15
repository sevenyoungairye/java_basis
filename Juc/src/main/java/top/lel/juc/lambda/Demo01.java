package top.lel.juc.lambda;

/**
 * @author echo lovely
 * @date 2021/2/15 11:08
 */

@FunctionalInterface
interface Foo {

    // 函数式接口只能有一个未实现方法
    int add(int x, int y);

    // 可多个静态
    static int div() {

        return 0;
    }

    // 可多个default
    default int mul(int x, int y) {
        System.out.println("multiply...");
        return x * y;
    }

}

public class Demo01 {

    public static void main(String[] args) {
        System.out.println(Foo.div());

        Foo foo = (int x, int y) -> {

            System.out.println("come in add...");
            return x + y;
        };

        System.out.println(foo.add(1, 4));

        System.out.println(foo.mul(9, 9));
    }

}
