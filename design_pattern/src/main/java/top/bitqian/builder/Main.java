package top.bitqian.builder;

/**
 * @author echo lovely
 * @date 2021/4/24 11:46
 * @description <p>
 *     缺点: 耦合性强, builder的顺序写死了, 还是再抽象类里面
 *     正确的是: 有 产品, 构建者, 具体构建者, 指挥者四个角色
 * </p>
 */

public class Main {

    public static void main(String[] args) {
        AbstractBuilder builder = new CommonHouse();
        builder.builder();
    }

}
