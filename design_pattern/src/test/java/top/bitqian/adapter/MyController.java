package top.bitqian.adapter;

/**
 * @author echo lovely
 * @date 2021/4/26 20:05
 * @description <p>
 *     模拟spring-mvc源码 手撕handler
 * </p>
 */

public interface MyController {

}

class SimpleController implements MyController {

    public void doSimpleHandler() {
        System.out.println("simple handler");
    }

}

class HttpController implements MyController {

    public void doHttpController() {
        System.out.println("http controller");
    }

}
 // ..
