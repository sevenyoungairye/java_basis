package top.lel.lc.easy.single_number;

import java.util.Arrays;

/**
 * @author echo lovely
 * @apiNote
 *          <p>
 *          出现一次的数字：
 *          https://leetcode.cn/problems/single-number/description/
 *          <ol>
 *          <li>
 *          交换律：a ^ b ^ c <=> a ^ c ^ b
 * 
 *          任何数于0异或为任何数 0 ^ n => n
 * 
 *          相同的数异或为0: n ^ n => 0
 *          </li>
 *          </ol>
 *          </p>
 * @since 2022/09/06 13:51
 */
public class SingleNumber {

    public static void main(String[] args) {
        var param = new int[] { 4, 1, 2, 1, 2 };
        var r = singleNumber(param);
        System.out.println("===> " + r);

        r = upgrade(param);
        System.out.println("===> " + r);
    }

    public static int singleNumber(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            System.err.println(nums[i]);
            if (i + 1 < len && nums[i] == nums[i + 1]) {
                i++;
                continue;
            } else {
                return nums[i];
            }
        }

        return -1;
    }

    public static int upgrade(int[] nums) {
        int len = nums.length;
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
