package top.lel.jvm;

/**
 * 栈管运行
 * 实例方法 8种基本数据类型 引用类型
 * stackOverFlowError 属于错误 不易捕捉
 * Throwable -> error + exception
 * @author echo lovely
 * @date 2021/2/26 21:59
 */

public class StackDemo {

    static void m1() {
        // Exception in thread "main" java.lang.StackOverflowError
        // error... 栈给撑爆了
        m1();
    }


    public static void main(String[] args) {

        System.out.println("1");

        m1();

        System.out.println("2");

    }

}
