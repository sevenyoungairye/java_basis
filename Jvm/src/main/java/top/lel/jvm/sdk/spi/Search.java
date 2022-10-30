package top.lel.jvm.sdk.spi;

import java.util.List;

/**
 * @author echo lovely
 * @apiNote 搜索接口 spi机制(service provider interface)
 * @since 2022/10/27 16:43
 */
@FunctionalInterface
public interface Search {

    List<String> searchDoc(String keyword);

}
