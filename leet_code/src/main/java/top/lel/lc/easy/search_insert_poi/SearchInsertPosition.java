package top.lel.lc.easy.search_insert_poi;


/**
 * @author echo lovely
 * @description 找到某个元素在排序数组的位置, 如果找不到
 * 按顺序插入, 并返回位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * @since 2022/4/14 17:13
 */

public class SearchInsertPosition {

    public static void main(String[] args) {

        /*int i = searchInsert(new int[]{1, 3, 5, 6}, -88);
        System.out.println(i);*/

        int upgrade = upgrade(new int[]{1, 2, 3, 5, 6, 8}, 999);
        System.out.println(upgrade);
    }

    // 二分法
    public static int upgrade(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        System.out.println(left + (right - left) / 2);
        System.out.println((left + right) / 2);

        while (left < right) {

            int mid = left + (right - left) / 2;
            // System.out.println("中间下标..." + mid);

            if (nums[mid] < target) {
                // [mid + 1, right]
                left = mid + 1;
            } else {
                // [left, mid]
                right = mid;
            }
            // System.out.println(String.format("left: %s, right: %s", left, right));
        }

        //System.out.println(String.format("left: %s, right: %s", left, right));
        return left;
    }


    public static int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }

        int res = 0;
        int[] arr = new int[nums.length + 1];

        int len = arr.length;
        // 拷贝一份数
        for (int i = 0; i < len - 1; i++) {
            arr[i] = nums[i];
        }
        arr[len - 1] = 0;

        for (int i = 0; i < len; i++) {
            // 1. 要找的数比数组中的数小
            if (target < arr[i]) {
                for (int j = 0; j < len - 1; j++) {
                    arr[j + 1] = nums[j];
                }
                arr[0] = target;
                break;
            }

            // 2. 要找的数大于数组中的某个数
            if (target > arr[i] && i < len - 1 && target <= arr[i + 1]) {
                int insertIndex = i + 1;
                res = insertIndex;
                for (int k = insertIndex; k < len - 1; k++) {
                    arr[k + 1] = nums[k];
                }
                arr[res] = target;
                break;
            }
        }

        // 要找的数最大
        if (arr[len - 1] == 0) {
            arr[len - 1] = target;
            return len - 1;
        }

        return res;
    }
}
