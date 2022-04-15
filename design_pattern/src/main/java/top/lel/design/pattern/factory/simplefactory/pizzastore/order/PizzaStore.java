package top.lel.design.pattern.factory.simplefactory.pizzastore.order;

/**
 * @author echo lovely
 * @date 2021/4/19 20:07
 * @description
 * <p>
 *     a client,
 * </p>
 */

public class PizzaStore {

    public static void main(String[] args) {
        // new OrderPizza();
        new OrderPizza(new SimpleFactory());

        new OrderPizza().setSimpleFactory(new SimpleFactory());
    }

}
