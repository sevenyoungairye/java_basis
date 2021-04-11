package top.bitqian.principle.dependency_inversion;

/**
 * @author echo lovely
 * @date 2021/4/11 10:28
 * @description
 * <P>
 *     依赖倒转原则:
 *     1. 面向接口编程
 *      <ul>
 *         <li>接口作为参数传递</li>
 *         <li>构造方法传递接口</li>
 *         <li>setter传递接口参数</li>
 *      </ul>
 *     2. 接口, 抽象类的细节越少越好, 细节应该交给子类
 *     3. 注意点：
 *     <ul>
 *         <li>地模块尽量使用抽象类 或者接口, (两者都实现), more stable</li>
 *         <li>变量的声明类型尽量是接口或者抽象类, 在变量的使用和实际对象之间, 存在缓冲层, 有利于程序扩展和优化.</li>
 *         <li>继承遵循里氏替换原则</li>
 *     </ul>
 * </P>
 */

public class DemoInversion1 {

    public static void main(String[] args) {
        // somebody get a msg from email..
        // but he just got a email..
        new Person().receive(new Email());
    }

    static class Email {
        String getInfo() {
            return "from email: hello, adorable";
        }
    }

    static class Person {
        void receive(Email email) {
            String msg = email.getInfo();
            System.out.println(msg);
        }
    }

}
