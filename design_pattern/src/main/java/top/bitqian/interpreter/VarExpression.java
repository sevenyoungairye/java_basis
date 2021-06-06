package top.bitqian.interpreter;

import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/6/4 21:31
 * @description your desc
 */

public class VarExpression implements Expression {

    // a=1 a, b = 2 b ...
    private final String key;

    public VarExpression(String key) {
        this.key = key;
    }

    // 根据表达式键 获取值
    @Override
    public int interpreter(Map<String, Integer> varMap) {
        return varMap.get(key);
    }

}
