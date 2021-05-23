package top.bitqian.observer;

/**
 * @author echo lovely
 * @date 2021/5/23 11:20
 * @description baidu weather..
 */

public class BaiduSite implements ObserverSite {

    private WeatherObject weatherObj;

    @Override
    public void update(WeatherObject weatherObj) {
       this.weatherObj = weatherObj;

       this.display();
    }

    @Override
    public void display() {
        if (weatherObj != null) {
            System.out.println("百度天气为您提供最新的weather data..");
            System.out.println("今天温度 " + this.weatherObj.getTemperature());
            System.out.println("今天湿度 " + this.weatherObj.getHumidity());
            System.out.println("今天气压 " + this.weatherObj.getAirPressure());
        } else {
            throw new UnsupportedOperationException("pls update the weather before you display it...");
        }
    }

}
