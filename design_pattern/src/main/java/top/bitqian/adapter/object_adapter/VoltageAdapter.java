package top.bitqian.adapter.object_adapter;

/**
 * @author echo lovely
 * @date 2021/4/25 19:34
 * @description <p>
 *     适配器类
 * </p>
 */

public class VoltageAdapter implements Voltage5V {

    private final Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5v() {
        if (this.voltage220V != null) {
            System.out.println("~~~ 对象配器模式 ~~~");
            int src = this.voltage220V.output220v();
            int destination = src / 44;
            System.out.println("适配资源: " + destination);
            return destination;
        }

        throw new RuntimeException("无转换的电压..");
    }
}
