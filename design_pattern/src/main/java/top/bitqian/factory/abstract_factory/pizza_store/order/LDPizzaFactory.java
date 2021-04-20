package top.bitqian.factory.abstract_factory.pizza_store.order;

import top.bitqian.factory.abstract_factory.pizza_store.pizza.BJPeeperPizza;
import top.bitqian.factory.abstract_factory.pizza_store.pizza.LDCheesePizza;
import top.bitqian.factory.abstract_factory.pizza_store.pizza.Pizza;

/**
 * @author echo lovely
 * @date 2021/4/20 21:01
 * @description
 * <p>
 *     landon pizza 工厂
 * </p>
 */

public class LDPizzaFactory implements AbstractPizzaFactory {
    @Override
    public Pizza createPizza(String pizzaType) {
        System.out.println("抽象工厂模式生产pizza~~");
        if ("cheese".equalsIgnoreCase(pizzaType))
            return new LDCheesePizza();
        if ("peeper".equalsIgnoreCase(pizzaType))
            return new BJPeeperPizza();
        return null;
    }
}
