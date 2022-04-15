package top.lel.design.pattern.composite;

/**
 * @author echo lovely
 * @date 2021/5/4 16:17
 * @description <p>
 *     院系
 * </p>
 */

public class Department extends OrganizationComponent {

    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }

    @Override
    protected void print() {
        // 获取院系的部门名称和描述
        System.out.println("==========\t院系名称: " + getName() + "\t描述: " + getDesc() + "==========");
    }
}
