package top.lel.lc.easy.len_of_last_word;

/**
 * @author echo lovely
 * @date 2022/4/19 11:29
 * @description 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/solution/zui-hou-yi-ge-dan-ci-de-chang-du-by-leet-51ih/
 */

public class LenOfLastWord {

    public static void main(String[] args) {
        String str = "   fly me   to   the moon  ";
        String trim = str.trim();
        int i = trim.lastIndexOf(" ");
        String res = trim.substring(i + 1);
        System.out.println(res.length());

        int start = 0;
        int end = 0;
        int j = 0;
        char[] chars = str.toCharArray();
        for (int index = chars.length - 1; index >= 0; index--) {
            if (chars[index] != ' ') {
                if (end == 0) {
                    j = index + 1;
                    end = index + 1;
                }
                j--;
            } else {
                if (j > 0) {
                    start = j;
                    break;
                }
            }
        }

        System.out.println(start + "\t" + end);
        System.out.println(str.substring(start, end));
    }


    public static int lengthOfLastWord(String s) {
        int end = 0;
        int j = 0;

        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) != ' ') {
                if (end == 0) {
                    j = index + 1;
                    end = index + 1;
                }
                j--;
            } else {
                if (j > 0) {
                    break;
                }
            }
        }

        return end - j;
    }
}
