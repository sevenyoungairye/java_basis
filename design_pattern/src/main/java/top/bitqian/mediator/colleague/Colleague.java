package top.bitqian.mediator.colleague;

import top.bitqian.mediator.Mediator;

/**
 * @author echo lovely
 * @date 2021/5/30 23:05
 * @description <p>
 *     抽象同事类
 *     用于通知, 拥有介者
 * </p>
 */

public abstract class Colleague {

    // 中介
    protected Mediator mediator;

    protected String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void sendMessage(int stateChange);

}
