package top.bitqian.strategy.improve.service;

import top.bitqian.strategy.improve.Duck;
import top.bitqian.strategy.improve.ToyDuck;
import top.bitqian.strategy.improve.WildDuck;

/**
 * @author echo lovely
 * @date 2021/6/7 19:38
 * @description test
 */

public class StrategyClient {

    public static void main(String[] args) {

        Duck duck = new ToyDuck();
        duck.setName("鸭子一号");
        duck.display();

        duck = new WildDuck();
        duck.setName("鸭子二号");
        duck.display();

    }

}
