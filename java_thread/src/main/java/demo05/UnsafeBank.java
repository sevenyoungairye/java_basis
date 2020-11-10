package demo05;

/**
 * 模拟银行取钱 两个人同时取钱
 * @author echo lovely
 * @date 2020/11/10 22:22
 */

public class UnsafeBank {

    public static void main(String[] args) {
        // 1000 元
        Account account = new Account(1000, "bank curd 01");

        DrawMoney d1 = new DrawMoney(account, 500, "小明");
        DrawMoney d2 = new DrawMoney(account, 600, "小丽");

        d1.start();
        d2.start();
    }

}

class Account {

    int money; // 余额

    String cardName; // 用来干嘛的

    public Account(int money, String cardName) {
        this.money = money;
        this.cardName = cardName;
    }


}

// 取钱
class DrawMoney extends Thread {

    Account account;

    // 取的钱
    int drawingMoney;

    // 卡里面还有多少钱
    int nowMoney;

    public DrawMoney(Account account, int drawingMoney, String name) {
        // 谁取的钱
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        if (account.money - drawingMoney <= 0) {
            System.out.println("余额不足，请充值。。。" + this.getName());
            return;
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.money = account.money - drawingMoney;

        nowMoney += drawingMoney;

        System.out.println("卡里面还有：" + account.money);
        System.out.println(this.getName() + "手里面有：" + nowMoney);

    }
}
