package top.lel.design.pattern.visitor;

import top.lel.design.pattern.visitor.element.People;

import java.util.LinkedList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/5/12 20:11
 * @description <p>
 *     提供一个高层的接口，用来允许访问者访问元素
 * </p>
 */

public class ObjectStructure {

    List<People> list = new LinkedList<>();

    public void attach(People p) {
        list.add(p);
    }

    public void detach(People p) {
        list.remove(p);
    }

    public void display(Action action) {
        for (People ele : list) {
            ele.accept(action);
        }
    }

}
