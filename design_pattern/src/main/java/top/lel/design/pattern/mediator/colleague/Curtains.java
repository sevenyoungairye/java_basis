package top.lel.design.pattern.mediator.colleague;

import top.lel.design.pattern.mediator.Mediator;

/**
 * @author echo lovely
 * @date 2021/6/3 12:33
 * @description curtains..
 */

public class Curtains extends Colleague {

    public Curtains(Mediator mediator, String name) {
        super(mediator, name);

        super.getMediator().register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        super.getMediator().getMessage(stateChange, super.name);
    }

    public void upCurtains() {
        System.out.println("I'm holding up curtains...");
    }

}
