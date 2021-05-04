package top.bitqian.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/5/4 16:06
 * @description <p>
 *     university 下面可以有多个 college
 * </p>
 */

public class University extends OrganizationComponent {

    // 存放college
    private final List<OrganizationComponent> componentList = new ArrayList<>();

    public University(String name, String desc) {
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

    @Override
    public String getDesc() {
        return super.getDesc();
    }

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
