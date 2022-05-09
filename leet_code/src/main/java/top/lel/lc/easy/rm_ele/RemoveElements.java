package top.lel.lc.easy.rm_ele;

import java.util.Arrays;

/**
 * @author echo lovely
 * @description
 * 移除给定数组中存在的元素, 并返回修改后的长度, 数组元素顺序可以改变
 * @since 2022/4/14 11:01
 */

public class RemoveElements {

    public static void main(String[] args) {

        int i = removeElement(new int[]{1, 4, 3, 2, 3, 4, 5, 4, 9}, 4);
        System.out.println(i);
    }

    /**
     * 返回数组的长度
     * 使用双指针覆盖...
     */
    public static int removeElement(int[] nums, int val) {

        /*
        如果右指针指向的元素不等于 val，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；
        如果右指针指向的元素等于 val，它不能在输出数组里，此时左指针不动，右指针右移一位。
         */
        // 左指针用于偏移, 要被覆盖的值
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }

        System.out.println(Arrays.toString(nums));

        return left;
    }
}
