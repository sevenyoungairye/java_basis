package top.lel.design.pattern.mediator.colleague;

import top.lel.design.pattern.mediator.Mediator;

/**
 * @author echo lovely
 * @date 2021/6/3 11:50
 * @description colleague 类实现
 */

public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);

        // 将同事对象放入中介者中..
        mediator.register(name, this);
    }

    // 闹钟铃响..
    public void sendAlarm(int stateChange) {
        this.sendMessage(stateChange);
    }

    @Override
    public void sendMessage(int stateChange) {
        super.getMediator().getMessage(stateChange, super.name);
    }

}
