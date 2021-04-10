package top.bitqian;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
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
    static Integer[][] sum(Integer [] arr, Integer target) {

        // 使用map解决, hhh
        Map<Integer, Integer> map = new LinkedHashMap<>();

        // map.getOrDefault(1, 2);

        for (int i = 0; i < arr.length; i++) {
             if (map.getOrDefault(i, i) + arr[i] == target) {

                 return new Integer[i][map.get(i)];
             }
             // put into map ..
            map.put(i, arr[i]);
        }

        // so so difficult understand...
        return null;
    }

    public static void main(String[] args) {
        // some body is so so gentle~ so so warm..
        // a a a ~~~

        Integer[][] sum = sum(new Integer[]{2, 3, 10, 9, 7}, 19);

        System.out.println(Arrays.deepToString(sum));

    }

}
