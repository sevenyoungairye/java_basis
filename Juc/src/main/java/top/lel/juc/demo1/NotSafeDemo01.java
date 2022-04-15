package top.lel.juc.demo1;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 不安全集合
 * // 问题 java.util.ConcurrentModificationException
 *
 * // 解决
 *      1. Vector 效率底下
 *      2. Collections.synchronizedList 效率底下
 *      3. CopyOnWriteArrayList 可
 *
 * 不安全set同理
 *
 * 不安全map同理
 * @author echo lovely
 * @date 2021/2/15 16:49
 */

public class NotSafeDemo01 {

    public static void main(String[] args) {

        // notSafeList();

        // notSafeSet();

        // test();

        notSafeMap();

    }

    private static void notSafeMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void notSafeSet() {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void notSafeList() {
        // 解决
        List<String> list = new CopyOnWriteArrayList<>();

        // n个线程跑a (a<=n)次
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)
            ).start();
        }
    }

    private static void test() {

        // HashSet 底层 -> hashMap

        HashMap<String, Object> map = new HashMap<>();

        map.put("abc", new Object());
        map.put("def", new Object());
        map.put("ghi", new Object());

        System.out.println(map.keySet());

    }

}
