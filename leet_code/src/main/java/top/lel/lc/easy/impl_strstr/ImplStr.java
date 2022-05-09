package top.lel.lc.easy.impl_strstr;

/**
 * @author echo lovely
 * @since 2022/4/14 17:01
 * @description your desc
 */

public class ImplStr {

    public static void main(String[] args) {

        int res = strStr("hello", "bba");
        System.out.println(res);
    }

    public static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null || haystack.isEmpty() || needle.isEmpty()) {
            return 0;
        }

        return haystack.indexOf(needle);
    }
}
