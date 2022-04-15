package top.lel.design.pattern.strategy.improve;

import top.lel.design.pattern.strategy.improve.service.GagaQuackBehavior;
import top.lel.design.pattern.strategy.improve.service.GoodFlyBehavior;

/**
 * @author echo lovely
 * @date 2021/6/7 19:27
 * @description WildDuck
 */

public class WildDuck extends Duck {
    // init. could fly, gaga
    public WildDuck() {
        super.setFlyBehavior(new GoodFlyBehavior());
        super.setQuackBehavior(new GagaQuackBehavior());
    }

    @Override
    public void display() {
        System.out.println(getName());
        getFlyBehavior().fly();
        getQuackBehavior().quack();
    }
}
