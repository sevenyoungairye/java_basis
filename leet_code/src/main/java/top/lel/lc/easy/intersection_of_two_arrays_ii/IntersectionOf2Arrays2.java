package top.lel.lc.easy.intersection_of_two_arrays_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author echo lovely
 * @since 2022/9/8
 * @apiNote 两数组的交集
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOf2Arrays2 {

    public static void main(String[] args) {

        var r = new IntersectionOf2Arrays2().intersect(new int[] { 3, 1, 2 }, new int[] { 1, 2 });
        System.out.println(Arrays.toString(r));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        var l1 = nums1.length;
        var l2 = nums2.length;

        // 保证nums1是长度小的数组, nums2是长度大些的数组。
        var tmp = nums2;
        if (l1 > l2) {
            nums2 = nums1;
            nums1 = tmp;
        }

        List<Integer> result = new ArrayList<>();

        // 方便快速找到相同的数
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums1) {
            // 缺少set 0
            map.computeIfAbsent(item, k -> 0);

            // 存在在原来的基础上+1
            map.computeIfPresent(item, (k, v) -> v + 1);
        }
        System.out.println(map);

        for (int item : nums2) {
            var count = map.get(item);
            if (count != null && count > 0) {
                // result.add(item);
                // map.put(item, --count);

                map.compute(item, (k, v) -> {
                    result.add(item);
                    return --v;
                });
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
