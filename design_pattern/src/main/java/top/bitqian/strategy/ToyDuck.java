package top.bitqian.strategy;

/**
 * @author echo lovely
 * @date 2021/6/7 16:54
 * @description toy
 */

public class ToyDuck extends Duck {
    @Override
    public void fly() {
        System.out.println("toy could'nt fly..");
    }


    @Override
    public void quack() {
        System.out.println("toy could'nt quack..");
    }

    @Override
    public void display() {
        System.out.println("I'm quack..");
    }

}
