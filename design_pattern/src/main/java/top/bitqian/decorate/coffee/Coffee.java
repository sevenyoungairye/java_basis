package top.bitqian.decorate.coffee;

/**
 * @author echo lovely
 * @date 2021/5/3 19:39
 * @description <p>
 *     主体, 被装饰者
 * </p>
 */

public class Coffee extends Drink {

    @Override
    public Float cost() {
        // 获取到coffee的价格
        return super.getPrice();
    }

}
