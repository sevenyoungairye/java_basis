package top.lel.design.pattern.template.improve;

/**
 * @author echo lovely
 * @date 2021/5/9 18:51
 * @description red bean..
 */

public class ReadBeanSoyMilk extends SoyMilk {

    @Override
    public void addCondiments() {
        // 无论是否实现, 取决consumerWantCondiment
    }

    // 钩子方法决定父类是否添加材料到豆浆
    @Override
    public boolean consumerWantCondiment() {
        return Boolean.FALSE;
    }
}
