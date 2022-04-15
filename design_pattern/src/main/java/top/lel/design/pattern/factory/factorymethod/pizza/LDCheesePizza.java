package top.lel.design.pattern.factory.factorymethod.pizza;

/**
 * @author echo lovely
 * @date 2021/4/19 21:58
 * @description
 * <p>
 *     landon cheese taste
 * </p>
 */

public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        super.setName("landon cheese pizza");
        System.out.println("landon cheese pizza preparing...");
    }
}
