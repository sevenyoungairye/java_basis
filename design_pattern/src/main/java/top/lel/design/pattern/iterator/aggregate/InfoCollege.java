package top.lel.design.pattern.iterator.aggregate;

import top.lel.design.pattern.iterator.Department;
import top.lel.design.pattern.iterator.InfoCollegeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/5/19 22:46
 * @description <p>
 *     信息学院
 * </p>
 */

public class InfoCollege implements College {

    private final List<Department> departmentList;

    public InfoCollege() {
        this.departmentList = new ArrayList<>();
        this.addDepartment(new Department("信息学院", "info college"));
    }

    @Override
    public void addDepartment(Department department) {
        this.departmentList.add(department);
    }

    @Override
    public String getName() {
        return "信息学院";
    }

    @Override
    public Iterator<Department> createIterator() {
        return new InfoCollegeIterator(this.departmentList);
    }
}
