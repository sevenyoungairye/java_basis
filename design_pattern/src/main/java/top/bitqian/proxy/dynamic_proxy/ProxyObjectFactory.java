package top.bitqian.proxy.dynamic_proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author echo lovely
 * @date 2021/5/9 12:00
 * @description JDK动态代理类
 */

public class ProxyObjectFactory {

    // 目标对象
    private final Object target;

    public ProxyObjectFactory(Object target) {
        this.target = target;
    }

    // 获取代理对象
    public Object getProxyInstance() {

        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            (Object proxy, Method method, Object[] args) -> {
                System.out.println("proxy 代理对象接口: " + proxy.getClass());
                System.out.println("代理的方法对象: " + method.getName());
                System.out.println("目标类方法参数: " + Arrays.toString(args));
                // 调用目标对象
                Object returnVal = method.invoke(target, args);
                System.out.println("调用目标方法返回值: " + returnVal);
                return returnVal;
        });
    }

}
