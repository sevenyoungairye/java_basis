package top.bitqian.visitor.element;

import top.bitqian.visitor.Action;

/**
 * @author echo lovely
 * @date 2021/5/12 19:59
 * @description Woman
 */

public class Woman extends People {

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
