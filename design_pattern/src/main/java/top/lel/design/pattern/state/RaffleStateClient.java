package top.lel.design.pattern.state;

/**
 * @author echo lovely
 * @date 2021/6/7 10:06
 * @description test
 */

public class RaffleStateClient {

    public static void main(String[] args) {

        // 2 raffles
        RaffleActivity activity = new RaffleActivity(2);

        for (int i = 1; i <= 50; i++) {

            System.out.format("第%d次抽奖...\n", i);

            activity.deductMoney();

            activity.raffle();
        }

    }

}
