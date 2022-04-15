package top.lel.design.pattern.strategy.improve.service;

/**
 * @author echo lovely
 * @date 2021/6/7 19:32
 * @description your desc
 */

public class NoQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("嘎嘎不能叫..");
    }
}
