package top.lel.design.pattern.state;

/**
 * @author echo lovely
 * @date 2021/6/6 22:08
 * @description 抽奖活动 当前的状态
 */

public class RaffleActivity {

    State state;

    // 组合四种状态
    NoRaffleState noRaffleState = new NoRaffleState(this);
    CanRaffleState canRaffleState = new CanRaffleState(this);
    DispenseState dispenseState = new DispenseState(this);
    DispenseOutState dispenseOutState = new DispenseOutState(this);

    int count;

    // construct
    // 1. 奖池大小
    // 2. 当前状态是未抽奖状态
    public RaffleActivity(int count) {
        this.count = count;
        state = this.getNoRaffleState();
    }

    // 扣除积分
    public void deductMoney() {
        this.state.deductMoney();
    }

    // 抽奖
    public void raffle() {
        if (this.state.raffle()) {
            // 领取奖品
            dispenseState.dispensePrize();
        }
    }

    // 奖品-1
    public int getCount() {
        return -- count;
    }

    // 当前状态setter/getter..
    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public NoRaffleState getNoRaffleState() {
        return this.noRaffleState;
    }

    public CanRaffleState getCanRaffleState() {
        return canRaffleState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public DispenseOutState getDispenseOutState() {
        return dispenseOutState;
    }
}
