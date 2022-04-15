package top.lel.design.pattern.proxy.static_proxy;

/**
 * @author echo lovely
 * @date 2021/5/9 11:54
 * @description test
 */

public class StaticProxyClient {

    public static void main(String[] args) {
        ITeacherDao target = new TeacherDao();
        ProxyObject proxyObject = new ProxyObject(target);
        proxyObject.teach();
    }

}
