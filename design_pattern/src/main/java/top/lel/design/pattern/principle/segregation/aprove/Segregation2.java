package top.lel.design.pattern.principle.segregation.aprove;


/**
 * @author echo lovely
 * @date 2021/4/10 18:30
 * @description
 * <p>
 *     隔离方案2, 拆分接口
 *     <a href="top.bitqian.principle.segregation.Segregation1">pls see</a>
 * </p>
 * @see top.lel.design.pattern.principle.segregation.Segregation1
 */

public class Segregation2 {

    public static void main(String[] args) {

        C c = new C();
        c.dependency1(new A());
        c.dependency2(new A());
        c.dependency3(new A());

        D d = new D();
        d.dependencyD1(new B());
        d.dependencyD2(new B());
        d.dependencyD3(new B());

    }

    /*
      将5个方法的接口, 拆分为3个部分, 让类来实现
     */

    interface MyInterface1 {
        void operation1();
    }

    interface MyInterface2 {
        void operation2();
        void operation3();
    }

    interface MyInterface3 {
        void operation4();
        void operation5();
    }

    /**
     * A 实现1,2,3方法
     */
    static class A implements MyInterface1, MyInterface2 {
        @Override
        public void operation1() {
            System.out.println("A impl operation1");
        }

        @Override
        public void operation2() {
            System.out.println("A impl operation2");
        }

        @Override
        public void operation3() {
            System.out.println("A impl operation3");
        }
    }

    /**
     * B实现了1,4,5 方法
     */
    static class B implements MyInterface1, MyInterface3 {
        @Override
        public void operation1() {
            System.out.println("B impl operation1");
        }

        @Override
        public void operation4() {
            System.out.println("B impl operation4");
        }

        @Override
        public void operation5() {
            System.out.println("B impl operation5");
        }
    }

    /**
     * C 通过拆分的MyInterface1 MyInterface2两个接口 间接的依赖了A类
     */
    static class C {
        public void dependency1(MyInterface1 i1) {
            i1.operation1();
        }
        public void dependency2(MyInterface2 i2) {
            i2.operation2();
        }
        public void dependency3(MyInterface2 i2) {
            i2.operation3();
        }
    }

    /**
     * D 通过拆分的 MyInterface1 MyInterface3两个接口 依赖了B
     */
    static class D {
        public void dependencyD1(MyInterface1 i1) {
            i1.operation1();
        }
        public void dependencyD2(MyInterface3 i3) {
            i3.operation4();
        }
        public void dependencyD3(MyInterface3 i3) {
            i3.operation5();
        }
    }

}
