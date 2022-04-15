package top.lel.design.pattern.memento.theory;

/**
 * @author echo lovely
 * @date 2021/6/4 11:20
 * @description 备忘录模式 纪念品
 *  备忘录对象,负责保存好记录，即 Originator 内部状态
 */

public class Memento {

    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
