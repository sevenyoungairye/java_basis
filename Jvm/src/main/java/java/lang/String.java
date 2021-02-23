package java.lang;

/**
 * 结合双亲委派机制 从上往下加载 bootstrap -> extension -> appClassLoader
 * @author echo lovely
 * @date 2021/2/23 11:10
 */

public class String {

    public static void main(String[] args) {

        /*
         * 错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
         *    public static void main(String[] args)
         * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
         */

        System.out.println("hhh, 沙箱隔离机制, 会先运行 启动类加载器bootstrap, cpp...");
    }

}
