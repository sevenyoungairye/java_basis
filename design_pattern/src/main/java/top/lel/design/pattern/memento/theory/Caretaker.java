package top.lel.design.pattern.memento.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/6/4 11:24
 * @description 管理者
 * 守护者对象,负责保存多个备忘录对象， 使用集合管理，提高效率
 * 可以存储单个, 集合, map对象
 */

public class Caretaker {

    private final List<Memento> mementoList = new ArrayList<>();

    public void save(Memento memento) {
        this.mementoList.add(memento);
    }

    public Memento get(int index) {
        return this.mementoList.get(index);
    }

}
