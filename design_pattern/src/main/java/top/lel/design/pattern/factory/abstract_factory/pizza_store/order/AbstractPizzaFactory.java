package top.lel.design.pattern.factory.abstract_factory.pizza_store.order;


import top.lel.design.pattern.factory.abstract_factory.pizza_store.pizza.Pizza;

/**
 * @author echo lovely
 * @date 2021/4/20 20:59
 * @description
 * <p>
 *     根据pizza类型产生pizza
 * </p>
 */

public interface AbstractPizzaFactory {

    Pizza createPizza(String pizzaType);

}
