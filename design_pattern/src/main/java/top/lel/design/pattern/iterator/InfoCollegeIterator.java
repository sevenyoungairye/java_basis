package top.lel.design.pattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/5/19 22:12
 * @description <p>
 *     信息学院迭代器遍历集合
 * </p>
 */

public class InfoCollegeIterator implements Iterator<Department> {

    private final List<Department> departmentList;

    private int position = 0;

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if (position >= departmentList.size() || departmentList.get(position) == null)
            return false;

        System.out.println();

        return true;
    }

    @Override
    public Department next() {

        return this.departmentList.get(this.position ++);
    }

    @Override
    public void remove() {

    }

}
