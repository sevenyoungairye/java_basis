package top.lel.design.pattern.factory.simplefactory.pizzastore.pizza;

/**
 * @author echo lovely
 * @date 2021/4/19 19:51
 * @description
 * <p>
 *     cheese pizza!
 * </p>
 */

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("cheese pizza preparing...");
    }
}
