package top.lel.design.pattern.strategy.improve.service;

/**
 * @author echo lovely
 * @date 2021/6/7 19:31
 * @description GoodFlyBehavior
 */

public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("奇鸭! 能够飞行..");
    }
}
