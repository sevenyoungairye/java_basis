package top.bitqian.interpreter;

import java.util.Map;
import java.util.Stack;

/**
 * @author echo lovely
 * @date 2021/6/4 21:39
 * @description cal..
 */

public class Calculator {

    private Expression expression;

    public Calculator(String expStr) {
        // construct data..

        Stack<Expression> stack = new Stack<>();

        char[] expCharArr = expStr.toCharArray();

        Expression left;
        Expression right;

        for (int i = 0; i < expCharArr.length; i++) {
            char ele = expCharArr[i];
            switch (ele) {
                case '+':
                    // + 左边的数字
                    left = stack.pop();
                    // + 右边的数字
                    right = new VarExpression(String.valueOf(expCharArr[++ i]));
                    // add push into stack..
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(expCharArr[++ i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                   // 表达式是数字, 如a, b, c...
                   stack.push(new VarExpression(String.valueOf(ele)));
            }
        }

        expression = stack.pop();

    }

    public int run(Map<String, Integer> varMap) {

        return this.expression.interpreter(varMap);
    }

}
