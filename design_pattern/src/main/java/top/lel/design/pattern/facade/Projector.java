package top.lel.design.pattern.facade;

/**
 * @author echo lovely
 * @date 2021/5/5 19:33
 * @description <p>
 *     .. 投影仪
 * </p>
 */

public class Projector {

    private Projector() {}

    private static final Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("Projector on..");
    }

    public void off() {
        System.out.println("Projector off..");
    }

    public void focus() {
        System.out.println("Projector focus..");
    }

    // 变焦
    public void zoom() {
        System.out.println("Projector off..");
    }

}
