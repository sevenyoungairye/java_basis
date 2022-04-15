package top.lel.design.pattern.state;

/**
 * @author echo lovely
 * @date 2021/6/6 22:10
 * @description 不可抽奖
 */

public class NoRaffleState implements State {

    private RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("当前是不可抽奖状态.. 扣除money..");
        // 不可抽奖 -> 可抽奖状态
        this.activity.setState(this.activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {

        System.out.println("扣除积分才可抽奖..");

        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("当前是不可抽奖状态.. 不分配奖品..");
    }
}
