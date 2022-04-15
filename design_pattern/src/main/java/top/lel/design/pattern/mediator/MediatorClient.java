package top.lel.design.pattern.mediator;

import top.lel.design.pattern.mediator.colleague.Alarm;
import top.lel.design.pattern.mediator.colleague.CoffeeMachine;
import top.lel.design.pattern.mediator.colleague.TV;

/**
 * @author echo lovely
 * @date 2021/6/3 14:31
 * @description test
 */

public class MediatorClient {

    public static void main(String[] args) {

        Mediator mediator = new ConcreteMediator();

        Alarm alarm = new Alarm(mediator, "alarm");


        new TV(mediator, "tv");

        new CoffeeMachine(mediator, "coffeeMachine");

        alarm.sendAlarm(0);

        alarm.sendAlarm(1);
    }

}
