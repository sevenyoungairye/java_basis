package top.bitqian.proxy.cglib_proxy;

/**
 * @author echo lovely
 * @date 2021/5/9 18:04
 * @description cglib client
 */

public class CglibProxyClient {

    public static void main(String[] args) {

        Object proxyInstance = new ProxyObjectFactory(new TeacherDao()).getProxyInstance();

        System.out.println(proxyInstance.getClass());

        TeacherDao proxyObj = (TeacherDao) proxyInstance;

        System.out.println(proxyObj.getClass());

        proxyObj.teach();
    }

}
