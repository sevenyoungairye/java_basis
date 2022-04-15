package top.lel.design.pattern.state.money;

/**
 * @author echo lovely
 * @date 2021/6/7 10:41
 * @description dd
 */

public interface State {
    /**
     * 电 审
     */
    void checkEvent(Context context);
    /**
     * 电审失败
     */
    void checkFailEvent(Context context);
    /**
     * 定价发布
     */
    void makePriceEvent(Context context);

    /**
     * 接单
     */
    void acceptOrderEvent(Context context);
    /**
     * 无人接单失效
     */
    void notPeopleAcceptEvent(Context context);
    /**
     * 付 款
     */
    void payOrderEvent(Context context);
    /**
     * 接单有人支付失效
     */
    void orderFailureEvent(Context context);
    /**
     * 反 馈
     */
    void feedBackEvent(Context context);

    String getCurrentState();

}
