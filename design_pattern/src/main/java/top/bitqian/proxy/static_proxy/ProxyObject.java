package top.bitqian.proxy.static_proxy;

/**
 * @author echo lovely
 * @date 2021/5/9 11:52
 * @description 代理类
 */

public class ProxyObject implements ITeacherDao {

    /**
     * 目标类
     */
    private final ITeacherDao target;

    public ProxyObject(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("静态代理, 代理类..");
        // 在访问目标方法之前进行添油加醋..
        target.teach();
    }

}
