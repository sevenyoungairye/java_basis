package top.lel.lc.easy.sqrtx;

/**
 * @author echo lovely
 * @date 2022/4/20 15:07
 * @description x的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */

public class Sqrtx {

    public static void main(String[] args) {

        // 9 = 3 * 3

        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(8));
    }

    // https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
    public static int mySqrt(int x) {

        if (x == 1)
            return 1;

        int left = 0;
        int right = x / 2;

        while (left < right) {
            int mid = (left + right) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right;
    }

}
