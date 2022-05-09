package top.lel.lc.easy.merge_sorted_arrs;

import java.util.Arrays;

/**
 * @author echo lovely
 * @date 2022/5/5 15:32
 * @description 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */

public class MergeSortedArr {

    public static void main(String[] args) {

        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void reverseDoublePointerMerge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }


    public static void doublePointerMerge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        for (int i = 0; i < nums1.length; i++) {
            if (i < m) {
                nums1[i] = nums1[i];
            } else {
                nums1[i] = nums2[--n];
            }
        }

        Arrays.sort(nums1);

        System.out.println(Arrays.toString(nums1));
    }

}
