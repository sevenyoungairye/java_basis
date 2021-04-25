package top.bitqian.adapter.object_adapter;

/**
 * @author echo lovely
 * @date 2021/4/25 19:31
 * @description <p>
 *     220v 电压
 *     被适配的类
 * </p>
 */

public class Voltage220V {

    public int output220v() {
        int src = 220;

        System.out.println("源电压" + src + "v");

        return src;
    }

}
