package top.bitqian.demo1;

import java.util.concurrent.TimeUnit;

/**
 * 普通锁 静态锁
 * 8lock...
 * @author echo lovely
 * @date 2021/2/16 14:07
 */

class Phone {

    synchronized static void sendQQ() {

        System.out.println("send qq msg..");
    }

    // third
    synchronized void sendEmail() throws InterruptedException {

        TimeUnit.SECONDS.sleep(3);
        System.out.println("send email...");
    }

    // second
    synchronized void sendMessage() {

        System.out.println("send message...");
    }

    // first
    void sayHello() {
        System.out.println("phone -> hello world...");
    }

}

public class Lock8Demo01 {


    public static void main(String[] args) {

        Phone p1 = new Phone();

        new Thread(() -> {
            try {
                p1.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "email.").start();

        new Thread(p1::sendMessage, "msg").start();

        new Thread(p1::sayHello, "hhh").start();

        new Thread(Phone::sendQQ, "jjj").start();
    }

}
