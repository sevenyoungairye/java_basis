package top.lel.design.pattern.interpreter;

import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/6/4 21:26
 * @description subtract
 */

public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(Map<String, Integer> varMap) {
        return super.left.interpreter(varMap) - super.right.interpreter(varMap);
    }
}
