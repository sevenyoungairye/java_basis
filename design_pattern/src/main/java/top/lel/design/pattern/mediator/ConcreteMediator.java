package top.lel.design.pattern.mediator;

import top.lel.design.pattern.mediator.colleague.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/6/3 12:23
 * @description mediator..
 */

public class ConcreteMediator extends Mediator {

    private final Map<String, Colleague> colleagueMap;

    private final Map<String, String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {

        this.colleagueMap.put(colleagueName, colleague);

        // ..
        if (colleague instanceof TV) {
            this.interMap.put("TV", colleagueName);
        }

        if (colleague instanceof Alarm) {
            this.interMap.put("Alarm", colleagueName);
        }

        if (colleague instanceof CoffeeMachine) {
            this.interMap.put("CoffeeMachine", colleagueName);
        }

        if (colleague instanceof Curtains) {
            this.interMap.put("Curtains", colleagueName);
        }
    }

    // 1. 根据得到的消息 完成任务
    // 2. 中介者在这个方法, 协调具体的同事对象, 完成任务..
    @Override
    public void getMessage(int stateChange, String colleagueName) {

        Colleague colleague = this.colleagueMap.get(colleagueName);

        // alarm ring..
        if (colleague instanceof Alarm) {

            CoffeeMachine cm = (CoffeeMachine) this.colleagueMap.get(this.interMap.get("CoffeeMachine"));

            if (stateChange == 0) {
                cm.startCoffee();

                TV tv = (TV) this.colleagueMap.get(this.interMap.get("TV"));
                tv.startTv();
            }

            if (stateChange == 1) {
                cm.finishCoffee();

                ( (TV) this.colleagueMap.get(this.interMap.get("TV")) ).stopTv();
            }
        }

        if (colleague instanceof TV) {
           TV tv =  (TV) this.colleagueMap.get(this.interMap.get("TV"));
           tv.startTv();
           tv.stopTv();
        }

        if (colleague instanceof Curtains) {
            Curtains curtains = (Curtains) this.colleagueMap.get(this.interMap.get("Curtains"));
            curtains.upCurtains();
        }

        if (colleague instanceof CoffeeMachine) {
            CoffeeMachine cm = (CoffeeMachine) this.colleagueMap.get(this.interMap.get("CoffeeMachine"));
            cm.finishCoffee();
        }

    }

}
