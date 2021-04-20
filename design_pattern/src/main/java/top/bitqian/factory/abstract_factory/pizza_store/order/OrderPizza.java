package top.bitqian.factory.abstract_factory.pizza_store.order;

import top.bitqian.factory.abstract_factory.pizza_store.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author echo lovely
 * @date 2021/4/20 21:06
 * @description
 * <p>
 *     订购pizza, 使用抽象工厂模式
 * </p>
 */

public class OrderPizza {

    private Pizza pizza;

    public OrderPizza(AbstractPizzaFactory pizzaFactory) {
        this.setPizzaFactory(pizzaFactory);
    }

    private void setPizzaFactory(AbstractPizzaFactory pizzaFactory) {

        do {
            this.pizza = pizzaFactory.createPizza(getType());

            if (pizza != null) {
                doPizza();
            } else {
                System.out.println("pizza is not existence..");
                break;
            }
        } while (true);

    }

    // make pizza details
    private void doPizza() {
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    private String getType() {
        System.out.println("pls enter pizza you liked... ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
