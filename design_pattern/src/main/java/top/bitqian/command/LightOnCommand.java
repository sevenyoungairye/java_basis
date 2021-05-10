package top.bitqian.command;

import top.bitqian.command.receiver.LightReceiver;

/**
 * @author echo lovely
 * @date 2021/5/10 22:11
 * @description light on..
 */

public class LightOnCommand implements Command {

    // 将命令的发送者和命令执行者light 分离
    private final LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
