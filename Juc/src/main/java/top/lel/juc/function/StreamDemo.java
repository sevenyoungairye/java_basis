package top.lel.juc.function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * stream demo & function interface!
 *
 * @author echo lovely
 * @date 2021/2/22 10:20
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
        // 支持链式编程
class Person {

    private Integer id;
    private String name;
    private int age;

    void doSth() {

        Person p = new Person().setAge(10).setName("bitQian666").setId(1);

        System.out.println(p);
    }

}

public class StreamDemo {


    public static void main(String[] args) {

        Person p1 = new Person(1, "a", 23);
        Person p2 = new Person(2, "b", 22);
        Person p3 = new Person(3, "c", 24);
        Person p4 = new Person(4, "d", 28);
        Person p5 = new Person(5, "e", 26);

        // id位偶数 年龄大于24 用户名转为大写 按字母倒序 第一个字母
        List<Person> userList = Arrays.asList(p1, p2, p3, p4, p5);

        userList.stream().
                filter(p -> p.getId() % 2 == 0).
                filter(p -> p.getAge() > 24).
                map(p -> p.getName().toUpperCase()).
                sorted(String::compareTo).
                limit(1).
                collect(Collectors.toList()).
                forEach(System.out::println);

        functionDemo();
        predicateDemo();
        consumerDemo();
        supplierDemo();

        new Person().doSth();
    }

    private static void supplierDemo() {
        // 供给型函数
        /*Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };*/

        Supplier<String> supplier = () -> "supplier 供给型函数 无参有返";
        System.out.println(supplier.get());

    }

    private static void consumerDemo() {
        // 消费型函数
        /*Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

                System.out.println("come in consumer type function..." + s);
            }
        };*/

        Consumer<String> consumer = str -> {
            System.out.println("消费型函数 有参无返");
            System.out.println(str);
        };

        consumer.accept("bitQian666");
    }

    private static void predicateDemo() {
        // 断定型接口

        /*Predicate<String> predicate = new Predicate<String>() {
            // 参数是泛型 返回是boolean
            // 调用test方法
            @Override
            public boolean test(String s) {
                return false;
            }
        };*/

        // 方法引用 判断输入的字符串 是否为空
        Predicate<String> predicate = String::isEmpty;

        System.out.println(predicate.test("hhh"));
    }

    private static void functionDemo() {
        // 函数型接口

        /*Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return null;
            }
        };*/
        Function<String, Integer> function = s -> {

            System.out.println("这是有参有返回的函数式接口!\t" + s);

            return 666;
        };

        System.out.println(function.apply("hello function!"));
    }

}

