package top.bitqian.state;


/**
 * @author echo lovely
 * @date 2021/6/6 22:13
 * @description 发放奖励
 */

public class DispenseState implements State {

    private RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发放状态, 不用扣除积分..");
    }

    @Override
    public boolean raffle() {

        System.out.println("领取奖品状态.. ");

        return false;
    }

    @Override
    public void dispensePrize() {

        int count = this.activity.getCount();

        if (count < 0) {
            System.out.println("不好意思, 奖品发放完了..");
            this.activity.setState(this.activity.getDispenseOutState());
            return;
        }

        System.out.println("成功发放某随机奖品.. ===================");
        // 不可抽奖..
        this.activity.setState(this.activity.getNoRaffleState());

    }
}
