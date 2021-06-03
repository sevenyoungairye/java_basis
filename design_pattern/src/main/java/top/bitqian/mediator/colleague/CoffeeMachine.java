package top.bitqian.mediator.colleague;

import top.bitqian.mediator.Mediator;

/**
 * @author echo lovely
 * @date 2021/6/3 12:02
 * @description 咖啡机..
 */

public class CoffeeMachine extends Colleague {

    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);

        // 将自己放入mediator map..
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        // 获取到mediator的消息
        super.getMediator().getMessage(stateChange, super.name);
    }

    public void startCoffee() {
        System.out.println("It's time to start coffee..");
    }

    public void finishCoffee() {
        System.out.println("Waiting five min!");
        System.out.println("Coffee is already..");
    }

}
