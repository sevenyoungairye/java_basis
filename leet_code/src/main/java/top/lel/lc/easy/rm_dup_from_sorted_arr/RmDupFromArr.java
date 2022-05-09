package top.lel.lc.easy.rm_dup_from_sorted_arr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author echo lovely
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 给定一升序重复数组，去重，然后返回去重后的长度...
 * @since 2022/4/13 16:45
 */

public class RmDupFromArr {

    public static void main(String[] args) {

        int i = removeDuplicates(new int[]{1, 1, 2, 3, 4, 4, 5});
        System.out.println(i);

        int i1 = solution2(new int[]{1, 1, 2, 3, 4, 4, 5});

        System.out.println(i1);
    }

    public static int solution2(int[] nums) {

//        int[] buildNums = new int[nums.length];
        // 使用j构造新数组
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[j] = nums[i];

//                buildNums[j] = nums[i];
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));


//        System.out.println("hh... " + Arrays.toString(copy(buildNums)));
        return j;
    }

    public static int removeDuplicates(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).distinct().boxed().collect(Collectors.toList());

        // nums = new int[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            nums[i] = collect.get(i);
        }
        System.out.println(Arrays.toString(nums));
        return collect.size();
    }

    public static int[] copy(int[] nums) {
        int len = 0;
        for (int num : nums) {
            if (num > 0) {
                len++;
            }
        }

        if (len > 0) {
            int[] res = new int[len];

            int j = 0;
            for (int num : nums) {
                if (num <= 0) {
                    continue;
                }
                res[j++] = num;
            }

            return res;
        }

        return null;
    }
}
