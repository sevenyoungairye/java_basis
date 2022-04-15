package top.lel.design.pattern.strategy;

/**
 * @author echo lovely
 * @date 2021/6/7 16:57
 * @description peking
 */

public class PekingDuck extends Duck {
    @Override
    public void fly() {
        System.out.println("peckingDuck could'nt fly..");
    }

    @Override
    protected void display() {
        System.out.println("I'm peking duck...");
    }
}
