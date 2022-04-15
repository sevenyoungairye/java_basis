package top.lel.design.pattern.flyweight;

/**
 * @author echo lovely
 * @date 2021/5/6 22:16
 * @description <p>
 *     .. String, Integer.valueOf, ... 线程池, 数据库连接池
 *     数据缓冲层..
 * 1) FlyWeight 是抽象的享元角色, 他是产品的抽象类, 同时定义出对象的外部状态和内部状态(后面介绍) 的接口
 * 或实现 Website
 * 2) ConcreteFlyWeight 是具体的享元角色，是具体的产品类，实现抽象角色定义相关业务 ConcreteWebsite
 * 3) UnSharedConcreteFlyWeight 是不可共享的角色，一般不会出现在享元工厂。 user
 * 4) FlyWeightFactory 享元工厂类，用于构建一个池容器(集合)， 同时提供从池中获取对象方法 WebsiteFactory
 * </p>
 */

public class FlyWeightClient {

    public static void main(String[] args) {

        WebsiteFactory factory = new WebsiteFactory();

        Website website = factory.getWebsite("新闻");
        website.use(new User("jack"));

        Website website1 = factory.getWebsite("博客");
        Website website2 = factory.getWebsite("博客");
        Website website3 = factory.getWebsite("博客");

        website1.use(new User("rose"));
        website2.use(new User("tom"));
        website3.use(new User("jerry"));

        System.out.println("网站数量: " + factory.getWebsiteCount());

    }

}
