package top.bitqian.visitor;

import top.bitqian.visitor.element.Man;
import top.bitqian.visitor.element.Woman;

/**
 * @author echo lovely
 * @date 2021/5/12 20:07
 * @description ConcreteVisitor
 */

public class Success extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(man.getName() + "给了成功的评价..");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(woman.getName() + "给了成功的评价..");
    }
}
