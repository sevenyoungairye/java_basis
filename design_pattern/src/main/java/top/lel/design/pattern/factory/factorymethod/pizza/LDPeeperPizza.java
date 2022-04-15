package top.lel.design.pattern.factory.factorymethod.pizza;

/**
 * @author echo lovely
 * @date 2021/4/19 21:59
 * @description
 * <p>
 *     landon peeper pizza
 * </p>
 */

public class LDPeeperPizza extends Pizza {
    @Override
    public void prepare() {
        super.setName("landon peeper pizza");
        System.out.println("landon peeper pizza preparing...");
    }
}
