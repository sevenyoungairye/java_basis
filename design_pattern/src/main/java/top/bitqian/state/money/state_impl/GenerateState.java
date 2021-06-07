package top.bitqian.state.money.state_impl;

import top.bitqian.state.money.AbstractState;
import top.bitqian.state.money.Context;
import top.bitqian.state.money.StateEnum;

/**
 * @author echo lovely
 * @date 2021/6/7 10:56
 * @description 订单生成
 */

public class GenerateState extends AbstractState {

    @Override
    public void checkEvent(Context context) {
        context.setState(new ReviewState());
    }

    @Override
    public void checkFailEvent(Context context) {
        context.setState(new FeedBackState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.GENERATE.getValue();
    }


}
