package top.lel.design.pattern.facade;

/**
 * @author echo lovely
 * @date 2021/5/5 19:39
 * @description ..
 */

public class Popcorn {

    private Popcorn() {}

    private static final Popcorn instance = new Popcorn();

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("popcorn on..");
    }

    public void off() {
        System.out.println("popcorn off..");
    }

    public void ready() {
        System.out.println("popcorn ready..");
    }
}
