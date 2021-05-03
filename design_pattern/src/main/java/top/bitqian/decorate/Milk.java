package top.bitqian.decorate;

import top.bitqian.decorate.coffee.Drink;

/**
 * @author echo lovely
 * @date 2021/5/3 20:01
 * @description <p>
 *     装饰者
 * </p>
 */

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        super.setDesc("牛奶");
        super.setPrice(3.00f);
    }

}
