package top.bitqian.factory.factorymethod.order;

import top.bitqian.factory.factorymethod.pizza.BJCheesePizza;
import top.bitqian.factory.factorymethod.pizza.BJPeeperPizza;
import top.bitqian.factory.factorymethod.pizza.Pizza;

/**
 * @author echo lovely
 * @date 2021/4/19 22:08
 * @description
 * <p>
 *     peking pizza reserve
 * </p>
 */

public class BJOrderPizza extends OrderPizza {

    // 根据pizza类型, 获取bj的pizza
    @Override
    public Pizza createPizza(String orderType) {

        if ("cheese".equalsIgnoreCase(orderType))
            return new BJCheesePizza();

        if ("peeper".equalsIgnoreCase(orderType))
            return new BJPeeperPizza();

        return null;
    }
}
