package top.lel.design.pattern.prototype.deep_clone;

/**
 * @author echo lovely
 * @date 2021/4/22 21:42
 * @description <p>
 *     深拷贝测试
 * </p>
 */

public class DeepCloneClient {

    public static void main(String[] args) throws Exception {

        deepPrototypeTest(Boolean.FALSE);

        deepPrototypeTest(Boolean.TRUE);

    }

    private static void deepPrototypeTest(Boolean isSerial) throws CloneNotSupportedException {

        DeepPrototype dp = new DeepPrototype();
        dp.setName("hah");
        DeepCloneableTarget target = new DeepCloneableTarget("r", "a girl");
        dp.setTarget(target);

        DeepPrototype dp1;
        DeepPrototype dp2;

        if (isSerial) {
            System.out.println("使用序列化方式实现深拷贝...");

            dp1 = (DeepPrototype) dp.cloneBySerial();
            dp2 = (DeepPrototype) dp.cloneBySerial();
        } else {
            System.out.println("实现clone方法 深拷贝...");
            dp1 = (DeepPrototype) dp.clone();
            dp2 = (DeepPrototype) dp.clone();
        }


        System.out.println(dp);
        System.out.println(dp1);
        System.out.println(dp2);

        System.out.println("===== 经测试, 深拷贝后的对象的引用类型不等 =====");
        System.out.println(target == dp1.getTarget());
        System.out.println(target == dp2.getTarget());
    }

}
