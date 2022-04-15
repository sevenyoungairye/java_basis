package top.lel.design.pattern.principle.segregation;

/**
 * @author echo lovely
 * @date 2021/4/10 17:46
 * @description
 * <p>
 *     接口隔离原则, 将接口拆分
 *
 *     业务：
 *     A, B 实现MyInterface
 *
 *     C 通过 MyInterface依赖(使用)A, operation1, 2, 3三个方法
 *     D 通过 MyInterface依赖B, 使用 operation1, 4, 5三个方法
 *
 *
 * </p>
 */

public class Segregation1 {

    public static void main(String[] args) {

        C c = new C();
        // c中依赖 A中, operation1,2,3 方法
        c.dependency1(new A());
        c.dependency2(new A());
        c.dependency3(new A());

        // d依赖B operation1,4.,5 方法
        D d = new D();
        d.dependencyD1(new B());
        d.dependencyD2(new B());
        d.dependencyD3(new B());

        /*
        分析： 现在, C 依赖A (1.2.3), D 依赖B (1.4.5),
        而A中的4,5方法, B中的2,3方法显得多余..
         */
    }

    /**
     * 定义接口, 5个方法 操作
     */
    interface MyInterface {
        void operation1();
        void operation2();
        void operation3();
        void operation4();
        void operation5();
    }

    /**
     * A 实现 MyInterface
     */
    static class A implements MyInterface {
        @Override
        public void operation1() {
            System.out.println("A operation1");
        }

        @Override
        public void operation2() {
            System.out.println("A operation2");
        }

        @Override
        public void operation3() {
            System.out.println("A operation3");
        }

        @Override
        public void operation4() {
            System.out.println("A operation4");
        }

        @Override
        public void operation5() {
            System.out.println("A operation5");
        }
    }

    /**
     * B 实现 MyInterface
     */
    static class B implements MyInterface {
        @Override
        public void operation1() {
            System.out.println("B operation1");
        }

        @Override
        public void operation2() {
            System.out.println("B operation2");
        }

        @Override
        public void operation3() {
            System.out.println("B operation3");
        }

        @Override
        public void operation4() {
            System.out.println("B operation4");
        }

        @Override
        public void operation5() {
            System.out.println("B operation5");
        }
    }

    // C, D类 通过MyInterface 依赖 A, B

    /**
     * 依赖A类 1,2,3
     */
    static class C {
        public void dependency1(MyInterface i) {
            i.operation1();
        }

        public void dependency2(MyInterface i) {
            i.operation2();
        }

        public void dependency3(MyInterface i) {
            i.operation3();
        }

    }

    /**
     * 依赖D 1,4,5
     */
    static class D {
        public void dependencyD1(MyInterface i) {
            i.operation1();
        }
        public void dependencyD2(MyInterface i) {
            i.operation4();
        }
        public void dependencyD3(MyInterface i) {
            i.operation5();
        }
    }

}

