package top.bitqian;

/**
 * @author echo lovely
 * @date 2021/2/23 11:03
 */

public class GetClassLoader {

    public static void main(String[] args) {

        // 获取启动类加载器 null
        System.out.println(Object.class.getClassLoader());

        System.out.println("\n\n************");

        // sun.misc.Launcher$AppClassLoader@18b4aac2 应用程序加载器
        System.out.println(GetClassLoader.class.getClassLoader());

        // sun.misc.Launcher$ExtClassLoader@1b6d3586 扩展加载器
        System.out.println(GetClassLoader.class.getClassLoader().getParent());

        // 启动类加载器为null
        System.out.println(GetClassLoader.class.getClassLoader().getParent().getParent());

        // 用户可继承 ClassLoader 自定义加载器。

    }

}
