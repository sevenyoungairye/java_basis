package top.lel.juc.demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author echo lovely
 * @date 2021/2/19 09:55
 */

class MyCache
{
    private volatile Map<String, Object> map = new HashMap<>();

    // 读写锁 可读 可写
    // 多线程写写, 多线程写读 加锁。多线程读读 不加锁。
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    void put(String key, Object value)
    {

        try
        {
            readWriteLock.writeLock().lock();

            System.out.println(Thread.currentThread().getName() + "\t 开始设置值 ===>key: " + key);
            try
            {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 设置值完成");
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            readWriteLock.writeLock().unlock();
        }


    }

    void get(String key)
    {

        try
        {
            readWriteLock.readLock().lock();

            System.out.println(Thread.currentThread().getName() + "\t 开始取值");
            try
            {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 取值完成 ===>value: " + map.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            readWriteLock.readLock().unlock();
        }

    }

}

public class ReadWriteLockDemo
{

    public static void main(String[] args)
    {

        MyCache myCache = new MyCache();

        for (int i = 1; i <= 3; i++)
        {
            final int tmp = i;
            new Thread(() -> myCache.put(String.valueOf(tmp), tmp), String.valueOf(i)).start();
        }

        for (int i = 1; i <= 3; i++)
        {
            final int tmp = i;
            new Thread(() -> myCache.get(String.valueOf(tmp)), String.valueOf(i)).start();
        }

    }

}
