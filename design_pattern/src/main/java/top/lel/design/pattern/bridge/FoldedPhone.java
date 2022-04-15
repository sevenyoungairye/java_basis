package top.lel.design.pattern.bridge;

/**
 * @author echo lovely
 * @date 2021/4/27 20:48
 * @description <p>
 *     可折叠式手机
 * </p>
 */

public class FoldedPhone extends Phone {

    protected FoldedPhone(Brand brand) {
        super(brand);
        System.out.println("折叠式手机~~~");
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
