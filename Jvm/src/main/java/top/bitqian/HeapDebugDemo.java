package top.bitqian;

/**
 * 堆demo
 * @author echo lovely
 * @date 2021/2/28 19:12
 */

public class HeapDebugDemo {

    public static void main(String[] args) {

        // -Xmx100M -Xms 100M -XX:+PrintGCDetails
        // 生产环境 设置到一样大
        System.out.println("-Xmx 最大分配内存 1/4 \t" + Runtime.getRuntime().maxMemory() / (double)1024 / 1024);
        System.out.println("-Xms 初始分配大小 1/64\t" + Runtime.getRuntime().totalMemory() / (double)1024 / 1024);

    }

}
