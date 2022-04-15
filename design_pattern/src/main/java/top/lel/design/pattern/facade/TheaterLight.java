package top.lel.design.pattern.facade;

/**
 * @author echo lovely
 * @date 2021/5/5 19:45
 * @description ..
 */

public class TheaterLight {

    private TheaterLight() {}

    private static final TheaterLight instance = new TheaterLight();

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("TheaterLight on..");
    }

    public void off() {
        System.out.println("TheaterLight off..");
    }

    public void dim() {
        System.out.println("TheaterLight dim..");
    }

    public void bright() {
        System.out.println("TheaterLight bright..");
    }

}
