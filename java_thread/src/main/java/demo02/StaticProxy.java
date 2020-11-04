package demo02;

/**
 * 静态代理
 * 静态代理模式，真实对象（目标），和代理对象都要实现同一个接口。
 * 代理对象要代理真实角色，所以
 * @author echo lovely
 * @date 2020/11/4 9:23
 */
public class StaticProxy {

    public static void main(String[] args) {

        // 好处：代理对象可以做目标对象做不了的事情
        // 目标对象可以专注做自己的事情
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.marry();

    }

}

interface Marry {

    /**
     * 结婚
     */
    void marry();

}

/**
 * me marry..
 */
class You implements Marry {

    @Override
    public void marry() {
        System.out.println("i'll marry with her !");
    }
}

/**
 * 婚介公司
 */
class WeddingCompany implements Marry {

    private Marry target;

    WeddingCompany(Marry target) {
        this.target = target;
    }

    void before() {
        System.out.println("before marry...");
    }

    void after() {
        System.out.println("after marry...");
    }

    @Override
    public void marry() {
        before();
        // 代理结婚
        target.marry();

        after();
    }
}

