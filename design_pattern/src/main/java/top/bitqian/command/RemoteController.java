package top.bitqian.command;

/**
 * @author echo lovely
 * @date 2021/5/10 22:18
 * @description <p>
 *     invoker, send command..
 * </p>
 */

public class RemoteController {

    Command[] onCommands;

    Command[] offCommands;

    Command undoCommand;

    public RemoteController() {
        // TODO: init..
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            // 初始化 on 和 off 的命令, 判null
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }

        undoCommand = new NoCommand();
    }

    // 给按钮设置命令
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    // 开按钮
    public void onButtonWasPushed(int no) {
        this.onCommands[no].execute();
        // 记录这个按钮 用于撤销
        this.undoCommand = this.onCommands[no];
    }

    // 关闭按钮
    public void offButtonWasPushed(int no) {
        this.offCommands[no].execute();
        this.undoCommand = this.offCommands[no];
    }

    // 撤销
    public void undo() {
        this.undoCommand.undo();
    }

}
