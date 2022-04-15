package top.lel.design.pattern.proxy.static_proxy;

/**
 * @author echo lovely
 * @date 2021/5/9 11:51
 * @description <p>
 *     目标类
 * </p>
 */

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("静态代理 目标类..");
    }
}
