package top.lel.design.pattern.visitor;

import top.lel.design.pattern.visitor.element.Man;
import top.lel.design.pattern.visitor.element.Woman;

/**
 * @author echo lovely
 * @date 2021/5/12 19:56
 * @description Visitor 访问者对象
 */

public abstract class Action {

    public abstract void getManResult(Man man);

    public abstract void getWomanResult(Woman woman);

}
