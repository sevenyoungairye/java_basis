package top.lel.design.pattern.decorate;

import top.lel.design.pattern.decorate.coffee.Drink;

/**
 * @author echo lovely
 * @date 2021/5/3 19:49
 * @description <p>
 *     装饰器, 组合coffee, 装饰coffee
 * </p>
 */

public class Decorator extends Drink {

    // 这里指代coffee主体, 被装饰者
    private final Drink drink;

    public Decorator(Drink obj) {
        this.drink = obj;
    }

    @Override
    public Float cost() {
        // super.getCost() 为装饰者coffee的价格.. 由子类实现
        // drink.cost() 被装饰者的价格
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDesc() {
        return "加入了装饰品: " + super.getDesc() + " 装饰品价格: " + super.getPrice() + " && " + drink.getDesc();
    }
}
