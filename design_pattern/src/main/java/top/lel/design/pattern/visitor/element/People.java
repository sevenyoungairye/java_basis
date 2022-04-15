package top.lel.design.pattern.visitor.element;

import lombok.Data;
import top.lel.design.pattern.visitor.Action;

/**
 * @author echo lovely
 * @date 2021/5/12 19:58
 * @description Element
 */

@Data
public abstract class People {

    private String name;

    public abstract void accept(Action action);

}
