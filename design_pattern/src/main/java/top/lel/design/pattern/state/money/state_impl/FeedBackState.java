package top.lel.design.pattern.state.money.state_impl;

import top.lel.design.pattern.state.money.AbstractState;
import top.lel.design.pattern.state.money.StateEnum;

/**
 * @author echo lovely
 * @date 2021/6/7 10:55
 * @description 已完结
 */

public class FeedBackState extends AbstractState {

    @Override
    public String getCurrentState() {
        return StateEnum.FEED_BACKED.getValue();
    }


}
