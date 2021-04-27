package top.bitqian.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/4/26 20:13
 * @description <p>
 *     core servlet
 *     适配器对controller进行适配
 * </p>
 */

public class DispatcherServlet {

    private static final List<MyHandlerAdapter> adapterList = new ArrayList<>();

    static {
        adapterList.add(new MySimpleHandlerAdapter());
        adapterList.add(new MyHttpHandlerAdapter());
    }

    static void doDispatch() {
        SimpleController handler = new SimpleController();
        // 获取到对应的适配器
        MyHandlerAdapter myAdapter = getAdapterForHandler(handler);
        if (myAdapter != null) {
            myAdapter.doHandler(handler);
        }
    }

    static MyHandlerAdapter getAdapterForHandler(MyController controller) {
        for (MyHandlerAdapter adapter : adapterList) {
            if (adapter.supports(controller)) {
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        doDispatch();
    }

}
