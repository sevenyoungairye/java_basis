package top.lel.design.pattern.memento.game;

/**
 * @author echo lovely
 * @date 2021/6/4 11:55
 * @description gr
 */

public class GameRole {

    private int atk;

    private int def;

    public GameRole(int atk, int def) {
        this.atk = atk;
        this.def = def;
    }

    // 保存游戏角色到备忘录
    public Memento createMemento() {
        return new Memento(atk, def);
    }

    public void recoverGameRoleFromMemento(Memento memento) {
        this.atk = memento.getAtk();
        this.def = memento.getDef();
    }

    public void display() {
        System.out.println("attack power: " + this.atk + "\t" + "defend power: " + this.def);
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }
}
