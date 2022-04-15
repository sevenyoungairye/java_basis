package top.lel.design.pattern.factory.abstract_factory.pizza_store.pizza;

/**
 * @author echo lovely
 * @date 2021/4/19 21:57
 * @description
 * <p>
 *     beijing peeper pizza
 * </p>
 */

public class BJPeeperPizza extends Pizza {
    @Override
    public void prepare() {
        super.setName("北京 peeper pizza");
        System.out.println("beijing peeper pizza preparing...");
    }
}
