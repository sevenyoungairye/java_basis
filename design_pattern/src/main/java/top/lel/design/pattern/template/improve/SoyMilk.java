package top.lel.design.pattern.template.improve;

/**
 * @author echo lovely
 * @date 2021/5/9 18:47
 * @description 使用模板方法制作豆浆
 */

public abstract class SoyMilk {

    // make 就是模板方法
    public final void make() {
        this.select();
        if (this.consumerWantCondiment())
            this.addCondiments();
        this.soak();
        this.beat();
    }

    public void select() {
        System.out.println("1. 准备原材料 豆子");
    }

    // 用于制作不同种类的
    public abstract void addCondiments();

    public void soak() {
        System.out.println("3. 浸泡豆子");
    }

    public void beat() {
        System.out.println("4. 打碎豆子");
    }

    // 钩子方法, 子类决定是否实现..
    public boolean consumerWantCondiment() {
        // 默认给豆浆添加配料
        return Boolean.TRUE;
    }

}
