package top.bitqian.state;

/**
 * @author echo lovely
 * @date 2021/6/6 22:01
 * @description 状态模式顶级接口: 描述多种状态..
 */

public interface State {

    /**
     * 扣除money
     */
    void deductMoney();

    /**
     *
     * @return 是否可抽奖
     */
    boolean raffle();

    /**
     * 发放奖品 分配
     */
    void dispensePrize();

}
