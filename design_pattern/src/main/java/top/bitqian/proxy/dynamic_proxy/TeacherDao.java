package top.bitqian.proxy.dynamic_proxy;

/**
 * @author echo lovely
 * @date 2021/5/9 11:57
 * @description 动态代理目标类
 */

public class TeacherDao implements ITeacherDao {
    @Override
    public void sayHi() {
        System.out.println("动态代理 目标方法, sayHi..");
    }

    @Override
    public void teach() {
        System.out.println("动态代理 目标方法, teach..");
    }
}
