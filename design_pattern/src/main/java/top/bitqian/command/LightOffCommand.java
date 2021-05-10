package top.bitqian.command;

import top.bitqian.command.receiver.LightReceiver;

/**
 * @author echo lovely
 * @date 2021/5/10 22:12
 * @description light off
 *
 */

public class LightOffCommand implements Command {

    private final LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
