package top.lel.design.pattern.bridge;

/**
 * @author echo lovely
 * @date 2021/4/27 20:54
 * @description <p>
 *     test
 * </p>
 */

public class Client {

    public static void main(String[] args) {
        Phone phone = new FoldedPhone(new Huawei());
        phone.open();
        phone.call();
        phone.close();

        System.out.println("===================");
        phone = new TouchScreenPhone(new IPhone());
        phone.open();
        phone.call();
        phone.close();
    }

}
