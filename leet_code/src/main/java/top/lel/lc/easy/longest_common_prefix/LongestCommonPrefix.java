package top.lel.lc.easy.longest_common_prefix;


/**
 * @author echo lovely
 * @date 2021/11/8 15:58
 * @description 公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {

//        String str = "hah";
//        System.out.println(str.substring(0, 1));

        String[] strs = {"flower", "flow", "flight"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);

        System.out.println(Solution.longestCommonPrefix(strs));
    }

    /*
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     */

    public static String longestCommonPrefix(String[] strs) {

        String ans = strs[0];

        if (("").equals(ans)) {
            return ans;
        }
        for (int i = 1; i < strs.length; i++) {
            String curNode = strs[i];
            int j = 0;
            for (; j < ans.length() && j < curNode.length(); j++) {
                if (ans.charAt(j) != curNode.charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);

            if ("".equals(ans)) {
                return ans;
            }
        }

        return ans;
    }


    /*
    分治。
     */
    private static class Solution {

        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            } else {
                return longestCommonPrefix(strs, 0, strs.length - 1);
            }
        }

        public static String longestCommonPrefix(String[] strs, int start, int end) {
            if (start == end) {
                return strs[start];
            } else {
                int mid = (end - start) / 2 + start;
                String lcpLeft = longestCommonPrefix(strs, start, mid);
                String lcpRight = longestCommonPrefix(strs, mid + 1, end);
                return commonPrefix(lcpLeft, lcpRight);
            }
        }

        public static String commonPrefix(String lcpLeft, String lcpRight) {
            int minLength = Math.min(lcpLeft.length(), lcpRight.length());
            for (int i = 0; i < minLength; i++) {
                if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                    return lcpLeft.substring(0, i);
                }
            }
            return lcpLeft.substring(0, minLength);
        }
    }

}
