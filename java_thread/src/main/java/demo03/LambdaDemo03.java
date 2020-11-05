package demo03;

/**
 * lambda el
 * @author echo lovely
 * @date 2020/11/5 8:30
 */
public class LambdaDemo03 {

    public static void main(String[] args) {

        // 一行代码可以省略代码块
        Calculate calculate = (a, b, c) -> a + b + c;

        int sum = calculate.sum(1, 2, 3);
        System.out.println(sum);

        Calculate res = (a, b, c) -> {

            System.out.println("lambda 装逼神器~");

            return a + b + c;
        };

        int sum1 = res.sum(1, 2, 3);
        System.out.println(sum1);
    }

}

interface Calculate {
    int sum(int a, int b, int c);
}
