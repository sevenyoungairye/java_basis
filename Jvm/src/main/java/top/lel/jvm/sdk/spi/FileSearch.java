package top.lel.jvm.sdk.spi;

import java.util.List;

/**
 * @author echo lovely
 * @apiNote 文件检索
 * @since 2022/10/27 16:45
 */

public class FileSearch implements Search {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件检索：" + keyword);
        return null;
    }
}
