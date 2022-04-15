package top.lel.design.pattern.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author echo lovely
 * @date 2021/5/23 11:16
 * @description 天气
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherObject {

    private Float temperature;

    private Float airPressure;

    private Float humidity;

}
