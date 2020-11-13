package demo06;

/**
 * 管程法
 * 生产者，消费者，产品，缓冲区
 * @author echo lovely
 * @date 2020/11/13 11:15
 */

public class TestPc {

    public static void main(String[] args) {

        SyncContainer container = new SyncContainer();
        new Customer(container).start();

        new Product(container).start();

    }

}

// 产品 肯德基
class Chicken {

    // 第多少只鸡
    int id;

    public Chicken(int id) {
        this.id = id;
    }

}

// 生产鸡
class Product extends Thread {

    // 定义容器
    SyncContainer container;

    public Product(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 生产鸡
            container.push(new Chicken(i));
            System.out.println("生产了第" + (i) + "只鸡");
        }
    }
}

// 消费鸡
class Customer extends Thread {

    // 定义容器
    SyncContainer container;

    public Customer(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第" + container.pop().id +  "只鸡");
        }
    }
}

// 缓冲区
class SyncContainer {

    // 容器 装鸡
    Chicken[] chickens = new Chicken[10];

    // 计数器
    int count = 0;

    // 生产者生产鸡
    public synchronized void push(Chicken chicken) {

        // 容器满了，需要等待消费者消费, 生产者等待
        if (count == chickens.length) {
            // 通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 容器没满，丢入产品, 生产者生产
        chickens[count] = chicken;
        count ++;

        // 通知消费者消费
        this.notifyAll();

    }

    // 消费者消费鸡
    public synchronized Chicken pop() {
        // 如果容器没有鸡，等待生产者生产，消费者等待
        if (count == 0) {

            // 消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果可消费
        count --;

        Chicken chicken = chickens[count];

        // 通知生产者生产
        this.notifyAll();

        return chicken;
    }

}




