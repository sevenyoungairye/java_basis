package top.lel.design.pattern.iterator.aggregate;

import top.lel.design.pattern.iterator.Department;

import java.util.Iterator;

/**
 * @author echo lovely
 * @date 2021/5/19 22:25
 * @description 聚合接口: 返回迭代器
 */
public interface College {

    // 新增院系
    void addDepartment(Department department);

    // 获取学院名称
    String getName();

    /**
     * 用于创建迭代器
     * @return data
     */
    Iterator<Department> createIterator();

}
