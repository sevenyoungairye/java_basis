package top.lel.design.pattern.memento.theory;

/**
 * @author echo lovely
 * @date 2021/6/4 11:18
 * @description
 * 备忘录模式
 * 操作Memento, 对象(需要保存状态的对象)
 */

public class Originator {


    private String state;

    public Memento saveMemento() {

        return new Memento(state);
    }

    public String getStateFromMemento(Memento memento) {

        return memento.getState();
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }



}
