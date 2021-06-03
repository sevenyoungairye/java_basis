package top.bitqian.mediator;

import top.bitqian.mediator.colleague.Colleague;

/**
 * @author echo lovely
 * @date 2021/5/30 23:06
 * @description 中介者
 */

public abstract class Mediator {

    // 将colleague同事 注册到集合
    public abstract void register(String colleagueName, Colleague colleague);

    // 获取同事对象的消息
    public abstract void getMessage(int stateChange, String colleagueName);

}
