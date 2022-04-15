package top.lel.design.pattern.mediator.colleague;

import top.lel.design.pattern.mediator.Mediator;

/**
 * @author echo lovely
 * @date 2021/6/3 12:28
 * @description tv
 */

public class TV extends Colleague {

    public TV(Mediator mediator, String name) {

        super(mediator, name);

        super.getMediator().register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        super.getMediator().getMessage(stateChange, super.name);
    }

    public void startTv() {
        System.out.println("tv start...");
    }

    public void stopTv() {
        System.out.println("tv stop...");
    }

}
