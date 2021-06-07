package top.bitqian.state.money;

/**
 * @author echo lovely
 * @date 2021/6/7 10:45
 * @description your desc
 */

public class AbstractState implements State {

    protected static final RuntimeException EXCEPTION = new RuntimeException("操作流程不允许");

    @Override
    public void checkEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void checkFailEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void makePriceEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void acceptOrderEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void notPeopleAcceptEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void payOrderEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void orderFailureEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void feedBackEvent(Context context) {
        throw EXCEPTION;
    }

    @Override
    public String getCurrentState() {
        throw EXCEPTION;
    }

}
