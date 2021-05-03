package top.bitqian.decorate;

import top.bitqian.decorate.coffee.Drink;

/**
 * @author echo lovely
 * @date 2021/5/3 20:10
 * @description <p>
 *     ..
 * </p>
 */

public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        super.setDesc("巧克力");
        super.setPrice(2.00f);
    }
}
