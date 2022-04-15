package top.lel.design.pattern.state.money.state_impl;

import top.lel.design.pattern.state.money.AbstractState;
import top.lel.design.pattern.state.money.Context;
import top.lel.design.pattern.state.money.StateEnum;

/**
 * @author echo lovely
 * @date 2021/6/7 11:02
 * @description 已发布
 */

public class PublishState extends AbstractState {
    @Override
    public void acceptOrderEvent(Context context) {
        //把当前状态设置为 NotPayState
        context.setState(new NotPayState());
    }

    @Override
    public void notPeopleAcceptEvent(Context context) {
        context.setState(new FeedBackState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.PUBLISHED.getValue();
    }
}
