package top.lel.design.pattern.state;

import java.util.Random;

/**
 * @author echo lovely
 * @date 2021/6/6 22:09
 * @description can raffle
 */

public class CanRaffleState implements State {

    private RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("已经扣除积分 可抽奖");
    }

    @Override
    public boolean raffle() {

        System.out.println("抽奖开始..");

        int i = new Random().nextInt(10);

        // 满足10%中奖率
        if (0 == i) {
            // 可以发送奖品
            this.activity.setState(this.activity.getDispenseState());

            return true;
        }

        System.out.println("很遗憾, 没有抽取到奖励..");

        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("抽奖状态, 不负责发送奖品..");
    }
}
