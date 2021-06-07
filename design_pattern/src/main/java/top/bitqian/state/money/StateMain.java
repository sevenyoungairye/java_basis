package top.bitqian.state.money;

import top.bitqian.state.money.state_impl.PublishState;

/**
 * @author echo lovely
 * @date 2021/6/7 11:07
 * @description your desc
 */

public class StateMain {
    public static void main(String[] args) {
        //创建 context 对象
        Context context = new Context();
        //将当前状态设置为 PublishState
        context.setState(new PublishState());
        System.out.println(context.getCurrentState());
        //publish --> not paycontext.acceptOrderEvent(context);
        //not pay --> paidcontext.payOrderEvent(context);
        // 失败, 检测失败时，会抛出异常
        /*try {
            context.checkFailEvent(context);
            System.out.println("流程正常..");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }

}