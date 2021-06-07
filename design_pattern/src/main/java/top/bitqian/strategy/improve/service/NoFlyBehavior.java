package top.bitqian.strategy.improve.service;

/**
 * @author echo lovely
 * @date 2021/6/7 19:31
 * @description NoFlyBehavior
 */

public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("duck不能飞行");
    }
}
