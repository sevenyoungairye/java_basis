package top.lel.design.pattern.bridge;

/**
 * @author echo lovely
 * @date 2021/4/27 20:45
 * @description <p>
 *     phone bridge
 * </p>
 */

public abstract class Phone {


    // 把品牌聚合起来
    // 这里来调用手机的功能
    private Brand brand;

    protected Phone(Brand brand) {
        this.brand = brand;
    }

    public void setPhone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        this.brand.close();
    }

    protected void call() {
        this.brand.call();
    }

}
