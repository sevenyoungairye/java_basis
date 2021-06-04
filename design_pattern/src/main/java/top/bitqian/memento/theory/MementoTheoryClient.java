package top.bitqian.memento.theory;

/**
 * @author echo lovely
 * @date 2021/6/4 11:27
 * @description test
 */

public class MementoTheoryClient {

    public static void main(String[] args) {

        Caretaker caretaker = new Caretaker();

        Originator originator = new Originator();
        originator.setState("state1...");
        caretaker.save(originator.saveMemento());

        originator.setState("state2...");
        caretaker.save(originator.saveMemento());

        originator.setState("state3...");
        caretaker.save(originator.saveMemento());

        Memento memento = caretaker.get(0);
        System.out.println("获取到备忘录状态:\t" + memento.getState());

    }

}
