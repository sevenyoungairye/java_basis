package top.bitqian.observer.subject;

import top.bitqian.observer.ObserverSite;
import top.bitqian.observer.WeatherObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/5/23 11:10
 * @description 气象站..
 */

public class WeatherData implements WeatherSubject {

    private final List<ObserverSite> observerList;

    private WeatherObject weatherObj;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(ObserverSite observerSite) {
        this.observerList.add(observerSite);
    }

    @Override
    public void removeObserver(ObserverSite observerSite) {
        this.observerList.remove(observerSite);
    }

    @Override
    public void setData(WeatherObject weatherObj) {
        this.weatherObj = weatherObj;
        this.notifyObserver();
    }

    @Override
    public void notifyObserver() {

        if (this.weatherObj == null) {
            this.weatherObj = new WeatherObject(0.0f, 0.0f, 0.0f);
            System.out.println("获取天气错误.. 请设置数据..");
        }

        for (ObserverSite observer : observerList) {
            observer.update(this.weatherObj);
        }
    }

}
