package top.bitqian.composite;

import lombok.Getter;
import lombok.Setter;

/**
 * @author echo lovely
 * @date 2021/5/4 15:58
 * @description <p>
 *     组合模式:
 *     component, 对象的声明接口, 组合leaf和composite,
 *     composite是子部件, 里面存储子部件, 操作子部件
 *     leaf是最小的节点
 * </p>
 */

@Setter
@Getter
public abstract class OrganizationComponent {

    private String name;

    private String desc;

    public OrganizationComponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void add(OrganizationComponent e) {
        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent e) {
        throw new UnsupportedOperationException();
    }

    // 由于展示当前组件的名称, 和包含的子组件信息
    protected abstract void print();

}
