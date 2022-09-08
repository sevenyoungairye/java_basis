package top.lel.lc.easy.valid_anagram;

import java.util.Arrays;

/**
 * 字母异位词：
 * 若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class ValidAnagram {
    public static void main(String[] args) {

        System.out.println(isAnagram("cpdd", "ddcp"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var s1 = s.toCharArray();
        var t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1, t1);
    }
}
