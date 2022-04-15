package top.lel.design.pattern.flyweight;

import lombok.Getter;
import lombok.Setter;

/**
 * @author echo lovely
 * @date 2021/5/6 22:18
 * @description <p>
 *   外部状态
 * </p>
 */

@Setter
@Getter
public class User {

    public User(String name) {
        this.name = name;
    }

    private String name;

}
