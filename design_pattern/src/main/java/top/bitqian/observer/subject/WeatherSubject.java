package top.bitqian.observer.subject;

import top.bitqian.observer.ObserverSite;
import top.bitqian.observer.WeatherObject;

/**
 * @author echo lovely
 * @date 2021/5/23 11:06
 * @description
 * 天气接口, 登记. 注册. 移除通知
 * 为一方, 对应多个观察者
 */
public interface WeatherSubject {

    void registerObserver(ObserverSite observerSite);

    void removeObserver(ObserverSite observerSite);

    void notifyObserver();

    void setData(WeatherObject weatherObj);
}
