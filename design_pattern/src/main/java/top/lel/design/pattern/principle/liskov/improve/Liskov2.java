package top.lel.design.pattern.principle.liskov.improve;

/**
 * @author echo lovely
 * @date 2021/4/12 21:17
 * @description <p>
 *     更好的解决方案
 * </p>
 */

public class Liskov2 {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("3-2=" + a.fun1(3, 2));

        System.out.println("----------");

        B b = new B();
        System.out.println("3+2=" + b.fun1(3, 2));

        System.out.println("3-2=" + b.fun2(3, 2));
    }


    static abstract class Base {

    }

    static class A extends Base {

        public int fun1(int a, int b) {
            return a - b;
        }

    }

    /**
     * 通过继承基类 解耦...
     */
    static class B extends Base {

        // 依赖 A
        private final A myA = new A();

        // B与A 无关 不可能认为是重写 add..
        int fun1(int a, int b) {
            return a + b;
        }

        int fun2(int a, int b) {
            return this.myA.fun1(a, b);
        }

    }

}

