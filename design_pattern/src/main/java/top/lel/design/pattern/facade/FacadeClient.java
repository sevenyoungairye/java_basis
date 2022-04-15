package top.lel.design.pattern.facade;

/**
 * @author echo lovely
 * @date 2021/5/5 20:04
 * @description test
 * 见Mybatis Configuration类中的几个工厂..
 */

public class FacadeClient {

    public static void main(String[] args) {

        HomeTheaterLight htl = new HomeTheaterLight();

        htl.ready();
        htl.play();
        htl.pause();
        htl.end();
    }

}
