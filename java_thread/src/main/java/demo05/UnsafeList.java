package demo05;

import java.util.ArrayList;
import java.util.List;

/**
 * 不安全的ArrayList
 * @author echo lovely
 * @date 2020/11/8 22:39
 */

public class UnsafeList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            // 10000个线程操作list集合
            new Thread(() -> {
                // 利用同步代码块 将 集合锁起来，一个一个的来，同步安全。
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("list的大小："  + list.size());
    }

}
