package top.bitqian.factory.simplefactory.pizzastore.order;

//import top.bitqian.factory.simplefactory.pizzastore.pizza.CheesePizza;
//import top.bitqian.factory.simplefactory.pizzastore.pizza.GreekPizza;
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

    /*public OrderPizza() {

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

    }*/

    public OrderPizza() {}

    public OrderPizza(SimpleFactory simpleFactory) {
        this.setSimpleFactory(simpleFactory);
    }

    // 使用工厂模式的好处, 将pizza的产生与预定pizza两个地方解耦
    // pizza只用在工厂生产, 而订购可以支持多方式订购...
    public void setSimpleFactory(SimpleFactory simpleFactory) {
        do {
            String pizzaType = getType();
            // 根据用户喜好, 生产对应的pizza
            this.pizza = simpleFactory.producePizza(pizzaType);
            if (this.pizza == null) {
                System.out.println("无此pizza, 程序退出...");
                System.exit(0);
                break;
            }
            this.pizza.setName(pizzaType);
            doPizza();
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
