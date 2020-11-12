package demo05;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 安全的集合 array list
 * @author echo lovely
 * @date 2020/11/12 08:40
 */

public class SafeArrayList {

    public static void main(String[] args) {

        // juc 编程 线程安全
        CopyOnWriteArrayList<String> writeArrayList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread( () -> writeArrayList.add(Thread.currentThread().getName()) ).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(writeArrayList.size());
    }

}
