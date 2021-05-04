package top.bitqian.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/5/4 16:14
 * @description <p>
 *     college下可以有多个department
 * </p>
 */

public class College extends OrganizationComponent {

    // 存放院系
    private final List<OrganizationComponent> componentList = new ArrayList<>();

    public College(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void add(OrganizationComponent e) {
        this.componentList.add(e);
    }

    @Override
    public void remove(OrganizationComponent e) {
        this.componentList.remove(e);
    }

    // 获取college的名字
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected void print() {
        System.out.println("==========" + getName() + "==========");

        for (OrganizationComponent ele : this.componentList) {
            ele.print();
        }
    }
}
