package top.lel.design.pattern.template;

/**
 * @author echo lovely
 * @date 2021/5/9 18:38
 * @description 花生豆浆
 */

public class PeanutSoyMilk extends SoyMilk {
    @Override
    public void addCondiments() {
        System.out.println("花生豆浆, 加入花生..");
    }
}
