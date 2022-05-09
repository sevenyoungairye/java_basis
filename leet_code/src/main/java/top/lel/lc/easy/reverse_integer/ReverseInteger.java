package top.lel.lc.easy.reverse_integer;

import java.util.Stack;

/**
 * @author echo lovely
 * @date 2021/11/8 11:36
 * @description 两数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 * 1. Integer.MIN_VALUE的绝对值不靠谱
 * 2. Integer.parseInt("9646324351") 转换过大数字, 可能出现异常
 */

public class ReverseInteger {

    public static void main(String[] args) {
        // the min value of integer, if you get a abs, it's will be a negative num..
        int val = -2147483648;

        int res = reverse(1534236469);
        System.out.println(res);

        // 结果是负数..
        System.out.println(-val);
        System.out.println(Math.abs((long) val));

        res = upgrade(val);
        System.out.println(res);
    }

    // 使用栈进行反转
    public static int reverse(int x) {
        if (x == 0)
            return x;

        if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }

        String s = String.valueOf(Math.abs(x));

        Stack<String> stack = new Stack<>();
        for (String ele : s.split("")) {
            stack.push(ele);
        }

        s = "";
        for (int i = stack.size() - 1; i >= 0; i--) {
            s = s.concat(stack.pop());
        }

        // 关于证数转换问题, 如果数字超出整数范围, 会报转换错误异常。
        // Integer.valueOf("9646324351");
        // Exception in thread "main" java.lang.NumberFormatException: For input string: "9646324351"
        long tmp = Long.parseLong(s);
        boolean flag = tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE;
        if (flag) {
            return 0;
        }

        if (x > 0) {
            x = Integer.parseInt(s);
            return x;
        }

        x = Integer.parseInt(s);
        return -x;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
     */
    public static int upgrade(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
