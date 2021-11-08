package top.bitqian.easy.two_sum;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 *
 * @author echo lovely
 * @date 2021/3/8 16:45
 */

public class DemoSum {

    /*
    *
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    *
    * */
    static int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int curVal = nums[i];

            // tips: 可以从 i + 1开始的
            for (int j = 0; j < len; j++) {
                boolean b = curVal + nums[j] == target && i != j;
                if (b) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    public static int[] upgrade(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

        int[] sum = twoSum(new int[]{2, 3, 10, 9, 7}, 19);
        System.out.println(Arrays.toString(sum));
        sum = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(sum));
        sum = upgrade(new int[]{2, 3, 10, 9, 7}, 12);
        System.out.println(Arrays.toString(sum));

        System.out.println("\n");
        sum = new int[]{1, 2, 3, 4};
        for (int i = 0; i < sum.length; ++i) {
            System.out.println(i);
        }
    }

}
