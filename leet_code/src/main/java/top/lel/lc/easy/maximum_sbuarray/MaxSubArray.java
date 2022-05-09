package top.lel.lc.easy.maximum_sbuarray;

/**
 * @author echo lovely
 * @description 53.最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @since 2022/4/18 09:48
 */

public class MaxSubArray {

    public static void main(String[] args) {

        // [-2,1,-3,4,-1,2,1,-5,4]
        int max = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});

        System.out.println("max is: " + max);
    }

    public static int maxSubArray(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int max = nums[0];
        int sum = 0;

        for (int num : nums) {
            /*int tmp = sum + num;
            if (num > tmp) {
                sum = num;
            } else {
                sum = tmp;
            }*/
            sum = Math.max(num, sum + num);
            max = Math.max(max, sum);
        }
        return max;
    }

    // j为arr数组的下标...
    static int sumArr(int[] arr, int j) {
        int res = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (i >= j) {
                res += arr[i];
            }
        }
        return res;
    }

}
