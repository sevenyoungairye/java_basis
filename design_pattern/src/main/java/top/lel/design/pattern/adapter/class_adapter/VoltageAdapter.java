package top.lel.design.pattern.adapter.class_adapter;

/**
 * @author echo lovely
 * @date 2021/4/25 19:34
 * @description <p>
 *     适配器类
 * </p>
 */

public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5v() {
        System.out.println("~~~ 类适配器模式 ~~~");
        int src = output220v();
        int destination = src / 44;
        System.out.println("适配资源: " + destination);
        return destination;
    }
}
