package top.lel.design.pattern.principle.dependency_inversion.improve;

/**
 * @author echo lovely
 * @date 2021/4/11 10:41
 * @description <p>
 *     模仿person接收消息
 * </p>
 */

public class DemoInversion2 {

    public static void main(String[] args) {

        /*
         * 依赖倒转 like 多态
         */
        Person p = new Person();
        p.receive(new Email());
        p.receive(new YouTelegram());

    }


    /**
     * 获取消息接口
     */
    interface IReceiver {
        String getInfo();
    }

    static class Email implements IReceiver {
        @Override
        public String getInfo() {
            return "from email: hello, adorable";
        }
    }

    static class YouTelegram implements IReceiver {
        @Override
        public String getInfo() {
            return "from t.me: hello, bitQian";
        }
    }

    /**
     * person 接收到消息
     */
    static class Person {
        void receive(IReceiver receiver) {
            String info = receiver.getInfo();
            System.out.println(info);
        }
    }

}
