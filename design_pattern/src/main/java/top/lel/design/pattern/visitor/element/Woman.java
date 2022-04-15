package top.lel.design.pattern.visitor.element;

import top.lel.design.pattern.visitor.Action;

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
