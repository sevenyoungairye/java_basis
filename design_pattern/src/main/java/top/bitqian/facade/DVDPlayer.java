package top.bitqian.facade;

/**
 * @author echo lovely
 * @date 2021/5/5 19:28
 * @description <p>
 *     ..
 * </p>
 */

public class DVDPlayer {

    private DVDPlayer() {}

    private static final DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("dvd on..");
    }

    public void off() {
        System.out.println("dvd off..");
    }

    public void play() {
        System.out.println("dvd play..");
    }

    public void pause() {
        System.out.println("dvd pause..");
    }

}
