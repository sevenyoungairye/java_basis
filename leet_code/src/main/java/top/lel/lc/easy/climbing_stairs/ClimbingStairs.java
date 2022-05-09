package top.lel.lc.easy.climbing_stairs;


/**
 * @author echo lovely
 * @date 2022/4/25 17:07
 * @description 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */

public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs(10));
    }

    // n是楼梯的层数
    public static int climbStairs(int n) {
        // 每次爬1层楼，或者2层楼
        // 1: 1
        // 2: 1+1 2
        // 3: 1+1+1 1+2 2+1
        // 5: 1+1+1+1 1+2+1 2+1+1 1+1+2 2+2
        // 8:
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
