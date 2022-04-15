package top.lel.design.pattern.memento.game;

/**
 * @author echo lovely
 * @date 2021/6/4 11:54
 * @description for game
 */

public class Memento {

    private int atk;

    private int def;

    public Memento(int atk, int def) {
        this.atk = atk;
        this.def = def;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }
}
