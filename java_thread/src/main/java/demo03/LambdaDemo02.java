package demo03;

/**
 * 带参数的lambda
 * @author echo lovely
 * @date 2020/11/4 22:12
 */
public class LambdaDemo02 {

    public static void main(String[] args) {
        Girl girl = new Girl() {

            @Override
            public void hotGirl(String name) {
                System.out.println("gorgeous girl -->" + name);
            }
        };

        girl.hotGirl("lucy");

        // 写法1 参数类型 & 变量
        girl = (String name) -> {
            System.out.println("lambda girl -->" + name);
        };

        girl.hotGirl("lucy1");

        // 写法2 省略参数类型
        girl = (name) -> {
            System.out.println("lambda girl -->" + name);
        };

        girl.hotGirl("lucy11");

        /*
        *   lambda表达式的使用条件：
        *
        *   1. 必须是函数式接口，接口只有一个抽象方法
        *   2. 简写，省略参数类型，必须都省略
        *
        *   语法: (param) -> {expression};
        * */

        Person p = (name, words) -> {
            System.out.println(name + "-->" + words);
        };

        p.sayHello("bitqian", "hello world!");
    }

}

interface Girl {

    void hotGirl(String name);

}

interface Person {
    void sayHello(String name, String words);
}
