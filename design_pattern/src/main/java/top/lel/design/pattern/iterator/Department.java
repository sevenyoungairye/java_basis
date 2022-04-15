package top.lel.design.pattern.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author echo lovely
 * @date 2021/5/19 22:00
 * @description <p>
 *     被迭代的元素
 * </p>
 */

@AllArgsConstructor
@Data
public class Department {

    private String name;

    private String desc;

    public Department() {

    }
}
