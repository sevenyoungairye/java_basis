package top.lel.design.pattern.principle.liskov;

import java.util.HashMap;
import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/4/12 20:34
 * @description
 * <p>
 *     继承缺点：
 *     <p>
 *       继承是侵入性的。只要继承，就必须拥有父类的所有属性和方法。
 *       降低了代码的灵活性。因为继承时，父类会对子类有一种约束。
 *       增强了耦合性。当需要对父类的代码进行修改时，必须考虑到对子类产生的影响。
 *       有时修改了一点点代码都有可能需要对打断程序进行重构。
 *     </p>
 *     里氏替换原则: <strong>只要有父类出现的地方，都可以用子类来替代</strong>
 *     <li>
 *         pls see <a href="https://www.jianshu.com/p/cf9f3c7c0df5">extends..</a>
 *     </li>
 *     <li>
 *        case1: 子类必须实现父类的抽象方法，但不得重写（覆盖）父类的非抽象（已实现）方法。
 *        case2: 子类中可以增加自己特有的方法。
 *        case3: 当子类覆盖或实现父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松。(形参更大)
 *        case4: 当子类的方法实现父类的抽象方法时，方法的后置条件（即方法的返回值）要比父类更严格。(返回更小)
 *     </li>
 * </p>
 */

public class Liskov1 {

    public static void main(String[] args) {

        A a = new A();
        System.out.println("3-2=" + a.fun1(3, 2));

        System.out.println("----------");

        B b = new B();
        System.out.println("3-2=" + b.fun1(3, 2));

        // 执行了父类方法, 但是hello并未被重写... 可能导致程序的混乱..
        Map<?, ?> map = new HashMap<>();
        Case3.A a1 = new Case3.A();
        a1.hello(map);
        // 执行了子类方法
        Case3.B b1 = new Case3.B();
        b1.hello(new HashMap<>());
        // {}父类的方法
        b1.hello(map);
    }

    static class A {
        // but that's sub.. 编程时有可能写错
        int fun1(int a, int b) {
            return a - b;
        }
    }

    /**
     * 子类不可实现父类已经实现的方法
     */
    static class B extends A {
        // add, 子类尽尽量不要覆盖父类已经实现的方法..
        @Override
        int fun1(int a, int b) {
            return a + b;
        }
    }

    static class Case3 {

        static class A {
            void hello(Map<?, ?> map) {
                System.out.println(map + "父类的方法");
            }
        }

        static class B extends Case3.A {
            // 重载了...
            void hello(HashMap<?, ?> map) {
                System.out.println(map + "子类的方法");
            }
        }

    }

    /**
     * 子类的返回必须比父类小
     */
    static class Case4 {

        static abstract class A {
            abstract Map<?, ?> fun1();
        }

        static class B extends Case4.A {
            /**
             * 返回值类型必须比父类的小, 否则编译器报错
             * @return null
             */
            HashMap<?, ?> fun1() {

                return null;
            }
        }

    }

}
