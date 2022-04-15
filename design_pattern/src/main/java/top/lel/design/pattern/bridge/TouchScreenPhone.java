package top.lel.design.pattern.bridge;

/**
 * @author echo lovely
 * @date 2021/4/27 20:52
 * @description <p>
 *     now
 * </p>
 */

public class TouchScreenPhone extends Phone {
    protected TouchScreenPhone(Brand brand) {
        super(brand);
        System.out.println("prevalent phone...");
    }

    @Override
    protected void open() {
        super.open();
    }

    @Override
    protected void close() {
        super.close();
    }

    @Override
    protected void call() {
        super.call();
    }
}
