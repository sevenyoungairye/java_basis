package top.lel.design.pattern.memento.game;

/**
 * @author echo lovely
 * @date 2021/6/4 12:06
 * @description test
 */

public class Caretaker {

    private Memento memento;

    // 保存多个game role
    // private List<Memento> mementoList;

    // 保存每个玩家的game role
    // private Map<String, List<Memento>> mementoMap;

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

}
