package top.lel.design.pattern.interpreter;

import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/6/4 21:12
 * @description 表达式顶级接口
 */

public interface Expression {

    // 解释公式和数值 {'a':1, 'b':2}, 返回最终结果..
    int interpreter(Map<String, Integer> varMap);

}
