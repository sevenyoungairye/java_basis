package top.bitqian.adapter.class_adapter;

/**
 * @author echo lovely
 * @date 2021/4/25 19:45
 * @description <p>
 *     ..
 * </p>
 */

public class Phone {
    void charging(Voltage5V voltage5V) {
        if (voltage5V.output5v() == 5)
            System.out.println("手机充电中....");
        else if (voltage5V.output5v() > 5)
            System.out.println("无法充电, 电压过高");
    }
}
