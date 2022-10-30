package top.lel.jvm.sdk.spi;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author echo lovely
 * @apiNote 测试spi
 * @since 2022/10/27 16:49
 */

public class TestCase {

    public static void main(String[] args) {
        // resources/META-INF/services 文件
        ServiceLoader<Search> loader = ServiceLoader.load(Search.class);
        for (Search search : loader) {
            System.out.println(search.searchDoc("dd"));
        }

       Search s = (keyword -> {
           System.out.println(keyword);
           return List.of("2", "33", "3");
       });

        System.out.println(s.searchDoc("hello world."));

    }

}
