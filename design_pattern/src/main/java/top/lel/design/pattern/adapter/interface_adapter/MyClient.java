package top.lel.design.pattern.adapter.interface_adapter;

/**
 * @author echo lovely
 * @date 2021/4/25 20:27
 * @description <p>
 *     接口适配器
 * </p>
 */

public class MyClient extends MyAbstractAdapter {

    public static void main(String[] args) {

        MyAbstractAdapter myAbstractAdapter = new MyAbstractAdapter() {
            @Override
            public void m1() {
                System.out.println("m1 method");
            }
        };

        myAbstractAdapter.m1();

    }

    static class T implements Hh {
        void _h() {
            say();
        }
    }

}

interface Hh {
    default void say() {
        System.out.println("hello..");
    }
}
