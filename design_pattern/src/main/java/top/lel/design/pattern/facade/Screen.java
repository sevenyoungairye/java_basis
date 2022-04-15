package top.lel.design.pattern.facade;

/**
 * @author echo lovely
 * @date 2021/5/5 19:43
 * @description ..
 */

public class Screen {

    private Screen() {}

    private static final Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void up() {
        System.out.println("Screen up..");
    }

    public void down() {
        System.out.println("Screen down..");
    }

}
