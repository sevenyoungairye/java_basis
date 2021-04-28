package top.bitqian.bridge;

/**
 * @author echo lovely
 * @date 2021/4/27 20:43
 * @description <p>
 *     iPhone
 * </p>
 */

public class IPhone implements Brand {

    @Override
    public void open() {
        System.out.println("ios iPhone open...");
    }

    @Override
    public void close() {
        System.out.println("ios iPhone close...");
    }

    @Override
    public void call() {
        System.out.println("ios iPhone call...");
    }
}
