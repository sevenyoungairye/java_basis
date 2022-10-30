package top.lel.lc.easy.intersection_of_two_arrays;

import java.util.Arrays;
import java.util.Stack;

public class IntersectionOf2Arrays {

    public static void main(String[] args) {
        var res = new IntersectionOf2Arrays().intersection(new int[] { 1, 3 }, new int[] { 2, 3, 3 });
        System.out.println(Arrays.toString(res));
    }

    // 求两个数组的交集，不考虑结果的顺序。
    public int[] intersection(int[] nums1, int[] nums2) {
        var l1 = nums1.length;
        var l2 = nums2.length;

        if (l1 <= 0 || l2 <= 0) {
            return new int[] {};
        }

        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < l1; i++) {
            this.add(stack, nums1[i], nums2);
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }

    private void add(Stack<Integer> res, int item, int[] nums) {
        for (int j : nums) {
            if (item == j && !res.contains(item)) {
                res.push(item);
            }
        }
    }
}
