package top.lel.design.pattern.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author echo lovely
 * @date 2021/6/4 21:36
 * @description test
 */

public class InterpreterClient {

    public static void main(String[] args) throws Exception {

        stackTest();

        String expStr = getExpStr();

        Map<String, Integer> varMap = getValue(expStr);

        Calculator calculator = new Calculator(expStr);
        int res = calculator.run(varMap);
        System.out.println("结果是: \t" + res);

    }

    // 获得表达式
    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    // 获得值映射
    public static Map<String, Integer> getValue(String expStr) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.print("请输入" + ch + "的值：");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }

    private static void stackTest() {
        Stack<String> myStack = new Stack<>();

        myStack.push("hah");
        myStack.push("abc");
        myStack.push("def");
        myStack.push("ghi");

        System.out.println(myStack.pop());

        System.out.println(myStack);
    }

}
