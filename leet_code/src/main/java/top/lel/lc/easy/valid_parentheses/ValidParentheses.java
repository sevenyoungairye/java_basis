package top.lel.lc.easy.valid_parentheses;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author echo lovely
 * @date 2022/1/4 09:55
 * @description 有效的括号
 */

public class ValidParentheses {
    /*
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
         
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/valid-parentheses
     */

    public static void main(String[] args) {


        // "(([]){})"

        System.out.println(checkByDeque("(([]){})"));

        System.out.println(checkByDeque("([0])"));
    }

    public static boolean easyDo(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }

        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }

        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            }

            if (s.contains("{}")) {
                s = s.replace("{}", "");
            }

            if (s.contains("[]")) {
                s = s.replace("[]", "");
            }
        }

        return s.length() == 0;
    }

    private static boolean checkByDeque(String s) {
        // "(([]){})"
        Deque<Character> deque = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                deque.push(')');
            } else if (c == '{') {
                deque.push('}');
            } else if (c == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || c != deque.pop()) {
                return false;
            }
         }

        return deque.isEmpty();
    }



    static Map<String, String> dataMap = new HashMap<>();
    static {
        // ()[]{}
        dataMap.put("(", ")");
        dataMap.put("[", "]");
        dataMap.put("{", "}");
    }

}
