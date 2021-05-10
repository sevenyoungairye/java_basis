package top.bitqian.command;

/**
 * @author echo lovely
 * @date 2021/5/10 22:05
 * @description <p>
 *     命令模式
 * </p>
 */
public interface Command {

    // 执行
    void execute();

    // 取消
    void undo();

}
