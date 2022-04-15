package top.lel.design.pattern.factory.factorymethod.order;

import top.lel.design.pattern.factory.factorymethod.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author echo lovely
 * @date 2021/4/19 22:00
 * @description
 * <p>
 *     基于工厂方法的 订购pizza, 产生pizza交给子类
 * </p>
 */

public abstract class OrderPizza {

    /**
     * 订购细节子类完成
     * @param orderType pizza的类型
     * @return 具体的某个pizza
     */
    protected abstract Pizza createPizza(String orderType);

    protected OrderPizza() {

        do {
            System.out.println("请输入你要订购的pizza: ");
            Pizza pizza = this.createPizza(getPizzaType());
            if (pizza == null) {
                System.out.println("订购失败");
                // System.exit(0);
                break;
            } else {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        } while (true);

    }

    private String getPizzaType() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
