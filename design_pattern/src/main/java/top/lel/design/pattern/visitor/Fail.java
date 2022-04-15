package top.lel.design.pattern.visitor;

import top.lel.design.pattern.visitor.element.Man;
import top.lel.design.pattern.visitor.element.Woman;

/**
 * @author echo lovely
 * @date 2021/5/12 20:08
 * @description ConcreteVisitor
 */

public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(man.getName() + "给了失败的评价..");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(woman.getName() + "给了失败的评价..");
    }
}
