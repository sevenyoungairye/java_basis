package top.lel.design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author echo lovely
 * @date 2021/5/6 22:12
 * @description <p>
 *
 * </p>
 */

public class WebsiteFactory {

    private final Map<String, ConcreteWebsite> pool = new HashMap<>();

    // 根据类型获取网站
    public Website getWebsite(String type) {

        if (! pool.containsKey(type)) {
            pool.put(type, new ConcreteWebsite(type));
        }

        return pool.get(type);
    }

    // 获取网站数量
    public int getWebsiteCount() {
        return this.pool.size();
    }

}
