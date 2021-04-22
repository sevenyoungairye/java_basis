package top.bitqian.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author echo lovely
 * @date 2021/4/22 19:47
 * @description
 * <p>
 *     原型设计模式, 可看spring的bean scope, singleton和prototype
 *
 *     <li>
 *         原型模式: 对某个对象进行复制, 被克隆的对象是不等的。
 *         不管是深拷贝还是浅拷贝, 对象的基本类型相同。
 *         如果是浅拷贝, 对象的引用类型相等;
 *         如果是深拷贝, 对象的引用类型不相等。
 *
 *         需求, 现有一只🐏, 需要将🐏复制 拷贝 克隆多份。
 *     </li>
 * </p>
 */

public class CloneSheepDemo {

    public static void main(String[] args) {

        shadeCopy();

        batchCopy();

    }

    static class A {}

    private static void shadeCopy() {

        System.out.println("实现Cloneable进行clone, 引用对象浅拷贝demo");

        ShadeSheep sheep = new ShadeSheep("duly", 3);

        // 引用对象会被浅拷贝, 指向同一个地址
        ShadeSheep friend = new ShadeSheep("secret", 1);
        sheep.setFriend(friend);

        A a = new A();
        sheep.setA(a);

        try {
            // 下面是由sheep 克隆过来
            ShadeSheep sheep1 = (ShadeSheep) sheep.clone();
            ShadeSheep sheep2 = (ShadeSheep) sheep.clone();
            ShadeSheep sheep3 = (ShadeSheep) sheep.clone();

            System.out.println(sheep);
            System.out.println(sheep1);
            System.out.println(sheep2);
            System.out.println(sheep3);

            System.out.println("原型🐏和克隆🐏equals方法比较: " + sheep.equals(sheep1));
            System.out.println("原型🐏和克隆🐏对象比较false: " + (sheep3 == sheep1));

            System.out.println("浅拷贝equals: " + friend.equals(sheep1.getFriend()));
            System.out.println("浅拷贝的引用对象比较是相等的: " + (friend == sheep1.getFriend()));
            System.out.println("浅拷贝的引用对象比较是相等的: " + (friend == sheep2.getFriend()));

            // True
            System.out.println(a == sheep1.a);
            System.out.println(a == sheep2.a);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 对象克隆实现
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ShadeSheep implements Cloneable {

        private String name;

        private Integer age;

        // 基本类型会被复制
        private String gender = "♂";

        // 浅拷贝 引用类型是一样的
        private ShadeSheep friend;

        private A a;

        public ShadeSheep(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            ShadeSheep shadeSheep;

            // 对象的浅拷贝 调用super.clone再转型
            shadeSheep = ((ShadeSheep) super.clone());

            return shadeSheep;
        }

    }

    // 普通拷贝
    private static void batchCopy() {
        System.out.println("\n传统方式拷贝: ");
        BatchSheep sheep = new BatchSheep("rose", 2);

        BatchSheep sheep1 = new BatchSheep(sheep.getName(), sheep.getAge());
        BatchSheep sheep2 = new BatchSheep(sheep.getName(), sheep.getAge());
        BatchSheep sheep3 = new BatchSheep(sheep.getName(), sheep.getAge());

        System.out.println(sheep);
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);

        System.out.println("@Data annotation, 重写了toString, equals是相等的: " + sheep.equals(sheep1));
        System.out.println("不同的内存地址: " + (sheep == sheep1));

        System.out.println();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class BatchSheep {

        private String name;

        private Integer age;
    }


}
