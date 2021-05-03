package top.bitqian.decorate;

import top.bitqian.decorate.coffee.Drink;
import top.bitqian.decorate.coffee.Espresso;

/**
 * @author echo lovely
 * @date 2021/5/3 20:11
 * @description <p>
 *     coffee bar..
 * </p>
 */

public class CoffeeBar {

    public static void main(String[] args) {
        Drink order = new Espresso();
        System.out.println("espresso的价格: " + order.getPrice());
        System.out.println("espresso的描述: " + order.getDesc());
        order = new Milk(order);

        String desc = order.getDesc();
        System.out.println(desc);
        System.out.println("加入牛奶后的价格: " + order.cost());

        order = new Chocolate(order);
        System.out.println(order.getDesc());
        System.out.println("加入牛奶, 加入chocolate的价格: " + order.cost());

        order = new Chocolate(order);
        System.out.println(order.getDesc());
        System.out.println("加入牛奶, 加入两份chocolate的价格: " + order.cost());
    }

}
