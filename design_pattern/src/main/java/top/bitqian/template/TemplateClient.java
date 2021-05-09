package top.bitqian.template;

/**
 * @author echo lovely
 * @date 2021/5/9 18:39
 * @description test. Spring IOC源码可看 模板方法模式
 */

public class TemplateClient {

    public static void main(String[] args) {
        SoyMilk peanutSoy = new PeanutSoyMilk();
        peanutSoy.make();
    }

}
