package top.bitqian.state.money.state_impl;

import top.bitqian.state.money.AbstractState;
import top.bitqian.state.money.Context;
import top.bitqian.state.money.StateEnum;

/**
 * @author echo lovely
 * @date 2021/6/7 10:56
 * @description 已付款
 */

public class PaidState extends AbstractState {

    @Override
    public void feedBackEvent(Context context) {
        context.setState(new FeedBackState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.PAID.getValue();
    }


}
