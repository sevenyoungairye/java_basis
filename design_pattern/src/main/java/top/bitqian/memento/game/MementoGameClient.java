package top.bitqian.memento.game;

/**
 * @author echo lovely
 * @date 2021/6/4 12:20
 * @description test
 */

public class MementoGameClient {

    public static void main(String[] args) {

        // 用于管理 游戏角色
        Caretaker caretaker = new Caretaker();

        GameRole gameRole = new GameRole(2, 3);

        Memento mementoOne = gameRole.createMemento();
        caretaker.setMemento(mementoOne);

        gameRole = new GameRole(4, 4);

        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());

        gameRole.display();

    }

}
