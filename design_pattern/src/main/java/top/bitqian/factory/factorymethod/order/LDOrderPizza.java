package top.bitqian.factory.factorymethod.order;

import top.bitqian.factory.factorymethod.pizza.LDCheesePizza;
import top.bitqian.factory.factorymethod.pizza.LDPeeperPizza;
import top.bitqian.factory.factorymethod.pizza.Pizza;

/**
 * @author echo lovely
 * @date 2021/4/19 22:07
 * @description
 * <p>
 *     landon pizza reserve..
 * </p>
 */

public class LDOrderPizza extends OrderPizza {
    @Override
    public Pizza createPizza(String orderType) {

        if ("cheese".equalsIgnoreCase(orderType))
            return new LDCheesePizza();

        if ("peeper".equalsIgnoreCase(orderType))
            return new LDPeeperPizza();

        return null;
    }
}
