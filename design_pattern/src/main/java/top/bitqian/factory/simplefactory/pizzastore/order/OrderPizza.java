package top.bitqian.factory.simplefactory.pizzastore.order;

import top.bitqian.factory.simplefactory.pizzastore.pizza.CheesePizza;
import top.bitqian.factory.simplefactory.pizzastore.pizza.GreekPizza;
import top.bitqian.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author echo lovely
 * @date 2021/4/19 19:54
 * @description
 * <p>
 *     订购pizza
 * </p>
 */

public class OrderPizza {

    private Pizza pizza;

    public OrderPizza() {

        do {
            String inputPizzaType = this.getType();
            if ("greek".equalsIgnoreCase(inputPizzaType)) {
                pizza = new GreekPizza();
                pizza.setName("greek");
                this.doPizza();
            } else if ("cheese".equalsIgnoreCase(inputPizzaType)) {
                pizza = new CheesePizza();
                pizza.setName("cheese");
                this.doPizza();
            } else {
                System.out.println("无此pizza, 程序退出...");
                System.exit(0);
                break;
            }
        } while (true);

    }

    private void doPizza() {
        this.pizza.prepare();
        this.pizza.bake();
        this.pizza.cut();
        this.pizza.box();
    }

    private String getType() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入你要订购的pizza类型: ");

        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }



}
