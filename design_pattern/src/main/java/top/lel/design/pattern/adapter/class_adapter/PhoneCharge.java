package top.lel.design.pattern.adapter.class_adapter;

/**
 * @author echo lovely
 * @date 2021/4/25 19:46
 * @description <p>
 *     ..
 * </p>
 */

public class PhoneCharge {

    public static void main(String[] args) {
        new Phone().charging(new VoltageAdapter());
    }

}
