package top.lel.design.pattern.facade;

/**
 * @author echo lovely
 * @date 2021/5/5 19:47
 * @description <p>
 *     外观模式: 这个类屏蔽了调用细节
 *     其它都是小接口实现
 * </p>
 */

public class HomeTheaterLight {

    private final TheaterLight theaterLight;

    private final Screen screen;

    private final Projector projector;

    private final DVDPlayer dvdPlayer;

    private final Stereo stereo;

    private final Popcorn popcorn;

    public HomeTheaterLight() {
        this.theaterLight = TheaterLight.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
        this.stereo = Stereo.getInstance();
        this.popcorn = Popcorn.getInstance();
    }

    // 封装调用
    public void ready() {
        popcorn.on();
        popcorn.ready();

        theaterLight.on();
        theaterLight.bright();

        screen.up();

        projector.on();

        stereo.up();

        dvdPlayer.on();

        theaterLight.dim();
    }

    public void play() {
        dvdPlayer.play();
    }

    public void pause() {
        dvdPlayer.pause();
    }

    public void end() {
        popcorn.off();
        theaterLight.bright();
        screen.down();
        projector.off();
        stereo.down();
        dvdPlayer.off();
    }

}
