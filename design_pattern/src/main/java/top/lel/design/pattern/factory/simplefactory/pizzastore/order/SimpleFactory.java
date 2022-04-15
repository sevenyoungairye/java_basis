package top.lel.design.pattern.factory.simplefactory.pizzastore.order;

import top.lel.design.pattern.factory.simplefactory.pizzastore.pizza.CheesePizza;
import top.lel.design.pattern.factory.simplefactory.pizzastore.pizza.GreekPizza;
import top.lel.design.pattern.factory.simplefactory.pizzastore.pizza.Pizza;

/**
 * @author echo lovely
 * @date 2021/4/19 20:35
 * @description <p>
 *     简单工厂模式, 用于生产piazza..
 *     应对订购pizza, 可能会又多种方式订购pizza
 * </p>
 */

public class SimpleFactory {

    // 这里也可以设置成静态的
    public Pizza producePizza(String pizzaType) {

        System.out.println("===== 简单工厂模式生产pizza! =====");

        Pizza pizza;

        if ("greek".equalsIgnoreCase(pizzaType)) {
            pizza = new GreekPizza();
        } else if ("cheese".equalsIgnoreCase(pizzaType)) {
            pizza = new CheesePizza();
        } else {
            pizza = null;
        }

        return pizza;
    }

}
