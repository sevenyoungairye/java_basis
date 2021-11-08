package top.bitqian.easy.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/11/8 15:07
 * @description https://leetcode-cn.com/problems/roman-to-integer/
 */

public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println(romanToInt("IV"));

        System.out.println(upgrade("XIV"));
        /*
            I             1
            V             5
            X             10
            L             50
            C             100
            D             500
            M             1000

            rules:
            I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
            X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
            C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

         */
    }


    static Map<String, Integer> paramMap = new HashMap<>();

    static {
        paramMap.put("I", 1);
        paramMap.put("V", 5);
        paramMap.put("X", 10);
        paramMap.put("L", 50);
        paramMap.put("C", 100);
        paramMap.put("D", 500);
        paramMap.put("M", 1000);
    }

    public static int romanToInt(String s) {
        int res = 0;

        String[] specArr = new String[]{"IV", "IX", "XL", "XC", "CD", "CM"};

        // 1. 计算指定的字符
        for (String ele : specArr) {
            if (s.contains(ele)) {
                res += getVal(ele);
                s = s.replace(ele, "");
            }
        }

        // 2. 计算正常相加的字符
        for (String ele : s.split("")) {
            // IV, 防止s是""
            if ("".equals(ele))
                return res;
            Integer val = paramMap.get(ele);
            res += val;
        }

        return res;
    }

    private static int getVal(String ele) {
        int val = 0;
        String[] node = ele.split("");
        for (String tmp : node) {
            Integer i = paramMap.getOrDefault(tmp, 0);
            val = Math.abs(val - i);
        }

        return val;
    }

    /*
        https://leetcode-cn.com/problems/roman-to-integer/solution/luo-ma-shu-zi-zhuan-zheng-shu-by-leetcod-w55p/
     */
    public static int upgrade(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {
        private static final long serialVersionUID = 4834716094584504863L;
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

}
