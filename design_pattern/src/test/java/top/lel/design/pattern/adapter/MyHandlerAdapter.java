package top.lel.design.pattern.adapter;

/**
 * @author echo lovely
 * @date 2021/4/26 20:08
 * @description <p>
 *     适配handler
 * </p>
 */

public interface MyHandlerAdapter {

    // 执行handler的方法
    void doHandler(Object handler);

    // 当前适配器是否支持处理器
    boolean supports(Object handler);

}

class MySimpleHandlerAdapter implements MyHandlerAdapter {
    @Override
    public void doHandler(Object handler) {
        if (null != handler)
            ((SimpleController) handler).doSimpleHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return handler instanceof SimpleController;
    }
}

class MyHttpHandlerAdapter implements MyHandlerAdapter {
    @Override
    public void doHandler(Object handler) {
        ((HttpController) handler).doHttpController();
    }

    @Override
    public boolean supports(Object handler) {
        return handler instanceof HttpController;
    }
}
