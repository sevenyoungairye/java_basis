package top.lel.design.pattern.state.money.state_impl;

import top.lel.design.pattern.state.money.AbstractState;
import top.lel.design.pattern.state.money.Context;
import top.lel.design.pattern.state.money.StateEnum;

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
