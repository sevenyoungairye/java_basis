package top.bitqian.factory.factorymethod.pizza;

/**
 * @author echo lovely
 * @date 2021/4/19 21:55
 * @description
 * <p>
 *     beijing cheese pizza
 * </p>
 */

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        super.setName("北京 cheese pizza");
        System.out.println("beijing cheese pizza preparing...");
    }
}
