package top.bitqian.interpreter;

import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/6/4 21:28
 * @description add
 */

public class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(Map<String, Integer> varMap) {
        return super.left.interpreter(varMap) + super.right.interpreter(varMap);
    }
}
