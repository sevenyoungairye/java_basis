package top.bitqian.proxy.dynamic_proxy;

/**
 * @author echo lovely
 * @date 2021/5/9 12:10
 * @description test
 */

public class DynamicProxyClient {

    public static void main(String[] args) {

        // 获取到代理对象
        Object proxyInstance = new ProxyObjectFactory(new TeacherDao()).getProxyInstance();

        ITeacherDao iTeacherDao = (ITeacherDao) proxyInstance;

        iTeacherDao.sayHi();

        System.out.println("======================");

        iTeacherDao.teach();

    }

}
