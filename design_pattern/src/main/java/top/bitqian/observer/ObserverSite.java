package top.bitqian.observer;

/**
 * @author echo lovely
 * @date 2021/5/23 11:08
 * @description <p>
 *     观察者网站, 订阅subject..
 *     更新自身天气..
 * </p>
 */

public interface ObserverSite {


    /**
     * 修改天气
     */
    void update(WeatherObject weatherObj);

    /**
     * 显示天气
     */
    void display();

}
