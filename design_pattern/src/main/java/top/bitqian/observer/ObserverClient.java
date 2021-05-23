package top.bitqian.observer;

import top.bitqian.observer.subject.WeatherData;
import top.bitqian.observer.subject.WeatherSubject;

/**
 * @author echo lovely
 * @date 2021/5/23 11:58
 * @description test
 * @see java.util.Observable
 */

public class ObserverClient {

    public static void main(String[] args) {

        WeatherObject currentWeather = new WeatherObject(20f, 80f, 22f);

        WeatherSubject subject = new WeatherData();
        BaiduSite baiduObserver = new BaiduSite();
        subject.registerObserver(baiduObserver);
        subject.setData(currentWeather);

    }

}
