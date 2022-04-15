package top.lel.design.pattern.command.client;

import top.lel.design.pattern.command.LightOffCommand;
import top.lel.design.pattern.command.LightOnCommand;
import top.lel.design.pattern.command.RemoteController;
import top.lel.design.pattern.command.receiver.LightReceiver;

/**
 * @author echo lovely
 * @date 2021/5/11 19:36
 * @description client
 * jdbcTemplate..
 */

public class CommandClient {

    public static void main(String[] args) {
        LightReceiver lightReceiver = new LightReceiver();

        RemoteController remoteController = new RemoteController();
        // 设置开和关的命令
        remoteController.setCommand(0, new LightOnCommand(lightReceiver), new LightOffCommand(lightReceiver));

        System.out.println("开启遥控...");
        remoteController.onButtonWasPushed(0);
        System.out.println("关闭遥控...");
        remoteController.offButtonWasPushed(0);
        System.out.println("撤销关闭操作...");
        remoteController.undo();
    }

}
