package top.bitqian.interpreter;

import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/6/4 21:18
 * @description 符号解析器, 每个运算符合, 和自己左右的两个数字有关..
 */

public class SymbolExpression implements Expression {

    protected Expression left;

    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public int interpreter(Map<String, Integer> varMap) {
        // 子类实现
        return 0;
    }

}
