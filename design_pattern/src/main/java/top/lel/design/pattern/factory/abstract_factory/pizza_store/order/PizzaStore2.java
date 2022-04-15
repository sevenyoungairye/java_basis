package top.lel.design.pattern.factory.abstract_factory.pizza_store.order;

/**
 * @author echo lovely
 * @date 2021/4/20 21:14
 * @description
 * order pizza!
 */

public class PizzaStore2 {

    public static void main(String[] args) {
        new OrderPizza(new BJPizzaFactory());
    }

}
