package top.lel.lc.easy.happy_number;

/**
 * @author echo lovely
 * @since 2022/9/7
 * @apiNote https://leetcode.cn/problems/happy-number/solution/
 */
public class HappyNumber {
    public static void main(String[] args) {
        // 567885
        System.out.println(isHappy(4));

        for (int i = 1; i < 366; i++) {
            if (isHappy(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    /**
     * the solution of leetcode website
     * https://leetcode.cn/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
     */
    public boolean upgrade(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    public static boolean isHappy(int n) {
        var s = String.valueOf(n);
        return compute(s) == 1;
    }

    private static int compute(String s) {

        String[] all = s.split("");
        var sum = 0;
        for (String item : all) {
            sum += Math.pow(Integer.parseInt(item), 2);
        }
        if (all.length <= 1) {
            var res = Integer.valueOf(s);
            if (res == 7) {
                return compute(String.valueOf(res * res));
            }
            return res;
        }

        return compute(String.valueOf(sum));
    }
}
