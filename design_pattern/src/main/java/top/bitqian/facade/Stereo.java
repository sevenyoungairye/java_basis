package top.bitqian.facade;

/**
 * @author echo lovely
 * @date 2021/5/5 19:37
 * @description <p>
 *     立体声
 * </p>
 */

public class Stereo {

    private Stereo() {}

    private static final Stereo instance = new Stereo();

    public static Stereo getInstance() {
        return instance;
    }

    public void up() {
        System.out.println("Stereo on..");
    }

    public void down() {
        System.out.println("Stereo off..");
    }
}
