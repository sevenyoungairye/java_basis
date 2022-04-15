package top.lel.design.pattern.adapter.object_adapter;

/**
 * @author echo lovely
 * @date 2021/4/25 20:10
 * @description <li>..</li>
 */

public class PhoneCharge1 {
    public static void main(String[] args) {
        // 对220v电压进行适配, 聚合
        new Phone().charging(new VoltageAdapter(new Voltage220V()));
    }
}
