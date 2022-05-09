package top.lel.lc.easy.plus_one;

import java.util.Arrays;

/**
 * @author echo lovely
 * @date 2022/4/19 13:51
 * @description plus one
 * https://leetcode-cn.com/problems/plus-one/
 */

public class PlusOne {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(plusOne(new int[]{1, 9, 9})));
    }

    public static int[] plusOne(int[] digits) {
        // case1: 都是9

        // case2: 后面是9, 前面的位数非9

        // case3: 最后一位不是9, 直接+1
        int len = digits.length;

        boolean isAll9Flg = true;
        for (int item : digits) {
            if (item != 9) {
                isAll9Flg = false;
                break;
            }
        }

        if (isAll9Flg) {
            int[] res = new int[len + 1];
            for (int i = 0; i < res.length; i++) {
                if (i == 0) {
                    res[i] = 1;
                } else {
                    res[i] = 0;
                }
            }
            return res;
        }

        // 最后一位非9;数组的后几位包括9
        // 2, 9, 3, 9, 9
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                break;
            } else {
                digits[i] = 0;
            }
        }

        return digits;
    }
}
