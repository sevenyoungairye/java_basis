package top.lel.jvm.sdk.spi;

import java.util.List;

/**
 * @author echo lovely
 * @apiNote 数据库检索
 * @since 2022/10/27 16:45
 */

public class DatabaseSearch implements Search {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("db search, search keyword: " + keyword);
        return List.of("handsome", "genius", "mild", "gen");
    }
}
