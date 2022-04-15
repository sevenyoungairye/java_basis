package top.lel.design.pattern.decorate.coffee;

import lombok.Data;

/**
 * @author echo lovely
 * @date 2021/5/3 19:33
 * @description <p>
 *     被装饰者, 也是主体
 *     也可以是装饰者
 * </p>
 */

@Data
public abstract class Drink {

    /**
     * 描述
     */
    private String desc;

    /**
     * 价格
     */
    private Float price = 0.00f;

    /**
     * 用来计算费用 成本
     * @return data
     */
    public abstract Float cost();

}
