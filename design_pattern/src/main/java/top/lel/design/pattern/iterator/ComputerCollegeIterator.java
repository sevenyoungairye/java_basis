package top.lel.design.pattern.iterator;

import java.util.Iterator;

/**
 * @author echo lovely
 * @date 2021/5/19 21:59
 * @description <p>
 *      计算机迭代器用来遍历数组,
 * </p>
 */

public class ComputerCollegeIterator implements Iterator<Department> {

    // 计算机系
    private final Department[] departments;

    private int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {

        if (position >= this.departments.length || null == this.departments[position])
            return false;

        System.out.println();
        return true;
    }

    @Override
    public Department next() {
        return this.departments[position++];
    }

    @Override
    public void remove() {
        System.out.println("do nothing..");
    }
}
