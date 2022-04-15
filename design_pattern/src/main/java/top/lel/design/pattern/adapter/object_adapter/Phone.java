package top.lel.design.pattern.adapter.object_adapter;

/**
 * @author echo lovely
 * @date 2021/4/25 19:45
 * @description <p>
 *     ..
 * </p>
 */

public class Phone {
    void charging(Voltage5V voltage5V) {
        int voltage = voltage5V.output5v();
        if (voltage == 5)
            System.out.println("手机充电中.... 电压刚好: " + voltage + "伏特");
        else if (voltage > 5)
            System.out.println("无法充电, 电压过高");
    }
}
