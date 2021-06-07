package top.bitqian.strategy.improve;

import top.bitqian.strategy.improve.service.NoFlyBehavior;
import top.bitqian.strategy.improve.service.NoQuackBehavior;

/**
 * @author echo lovely
 * @date 2021/6/7 19:28
 * @description ToyDuck
 */

public class ToyDuck extends Duck {

    public ToyDuck() {
        super.setFlyBehavior(new NoFlyBehavior());
        super.setQuackBehavior(new NoQuackBehavior());
    }

    @Override
    public void display() {
        System.out.println(super.getName());
        super.getFlyBehavior().fly();
        super.getQuackBehavior().quack();
    }
}
