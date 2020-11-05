package demo04;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程休眠，sleep：倒计时，打印当前时间
 *
 * 每个对象都有一个锁，sleep不会释放锁！
 * @author echo lovely
 * @date 2020/11/5 22:30
 */
public class ThreadLife02 {

    public static void main(String[] args) {

        try {
            turnTen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date date = new Date(System.currentTimeMillis());

        while (true) {
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            // 重新获取时间
            date = new Date(System.currentTimeMillis());
        }


    }

    /**
     * 10 秒倒计时
     * @throws InterruptedException exception
     */
    static void turnTen() throws InterruptedException {
        int i = 10;
        while (true) {
            System.out.println(i);

            Thread.sleep(1000);

            if (i == 0)
                break;

            i --;
        }
    }
}
