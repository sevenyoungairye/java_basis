package top.bitqian.factory.abstract_factory.pizza_store.order;


import top.bitqian.factory.abstract_factory.pizza_store.pizza.BJCheesePizza;
import top.bitqian.factory.abstract_factory.pizza_store.pizza.BJPeeperPizza;
import top.bitqian.factory.abstract_factory.pizza_store.pizza.Pizza;

/**
 * @author echo lovely
 * @date 2021/4/20 21:00
 * @description
 * <p>
 *     beijing pizza工厂, 生产bj的披萨
 * </p>
 */

public class BJPizzaFactory implements AbstractPizzaFactory {
    @Override
    public Pizza createPizza(String pizzaType) {
        System.out.println("抽象工厂模式生产pizza~~");
        if ("cheese".equalsIgnoreCase(pizzaType))
            return new BJCheesePizza();
        if ("peeper".equalsIgnoreCase(pizzaType))
            return new BJPeeperPizza();
        return null;
    }
}
