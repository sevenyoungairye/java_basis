package top.lel.design.pattern.state.money.state_impl;

import top.lel.design.pattern.state.money.AbstractState;
import top.lel.design.pattern.state.money.Context;
import top.lel.design.pattern.state.money.StateEnum;

/**
 * @author echo lovely
 * @date 2021/6/7 10:50
 * @description 已审核
 */

public class ReviewState extends AbstractState {

    @Override
    public void makePriceEvent(Context context) {
        context.setState(new PublishState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.REVIEWED.getValue();
    }

}
