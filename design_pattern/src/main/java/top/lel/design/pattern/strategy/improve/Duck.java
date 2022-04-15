package top.lel.design.pattern.strategy.improve;

import lombok.Data;
import top.lel.design.pattern.strategy.improve.service.FlyBehavior;
import top.lel.design.pattern.strategy.improve.service.QuackBehavior;

/**
 * @author echo lovely
 * @date 2021/6/7 18:56
 * @description
 */

@Data
public abstract class Duck {

    private String name;

    private FlyBehavior flyBehavior;

    private QuackBehavior quackBehavior;

    public void swim() {
        System.out.println("duck can fly..");
    }

    public abstract void display();

}
