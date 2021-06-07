package top.bitqian.state;

/**
 * @author echo lovely
 * @date 2021/6/6 22:15
 * @description 奖品领完..
 */

public class DispenseOutState implements State {

    private RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发放完了..");
    }

    @Override
    public boolean raffle() {

        System.out.println("奖品发放完了..");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发放完了..");
    }
}
