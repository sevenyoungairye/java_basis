package top.bitqian.strategy.improve.service;

import top.bitqian.strategy.improve.Duck;
import top.bitqian.strategy.improve.ToyDuck;
import top.bitqian.strategy.improve.WildDuck;

import java.util.Arrays;
import java.util.Comparator;

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

    static void compareDemo() {
        Integer[] arr = new Integer[] {1, 9, 6, 5};

        // 策略类
        Comparator<Integer> comparator= Integer::compareTo;

        Arrays.sort(arr, comparator);

        System.out.println(Arrays.toString(arr));

    }

}
