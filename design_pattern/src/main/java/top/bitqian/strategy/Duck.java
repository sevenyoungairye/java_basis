package top.bitqian.strategy;

/**
 * @author echo lovely
 * @date 2021/6/7 16:52
 * @description
 * <p>
 *     缺点：
 *     1. 子类需要重写父类方法..
 *     2. 改动子类 可能影响其它调用..
 * </p>
 */

public abstract class Duck {

    public void fly() {
        System.out.println("duck can fly..");
    }

    public void swim() {
        System.out.println("duck can fly..");
    }

    public void quack() {
        System.out.println("duck can quack..");
    }

    protected abstract void display();

}
