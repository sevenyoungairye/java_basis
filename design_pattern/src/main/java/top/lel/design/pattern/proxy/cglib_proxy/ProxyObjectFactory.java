package top.lel.design.pattern.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author echo lovely
 * @date 2021/5/9 17:54
 * @description 代理类 获取到代理对象
 */

public class ProxyObjectFactory implements InvocationHandler {

    // 目标对象
    private final Object target;

    public ProxyObjectFactory(Object target) {
        if (target instanceof TeacherDao)
            this.target = target;
        else
            throw new RuntimeException("目标错误, 不能代理...");
    }

    public Object getProxyInstance() {

        Enhancer enhancer = new Enhancer();
        // 为了创建目标类的子类, 即代理对象
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);

        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        // 用于调用目标方法
        System.out.println("对象o: " + o.getClass());
        Object invoke = method.invoke(this.target, args);
        System.out.println("调用目标方法结果: " + invoke);
        return invoke;
    }
}
