package top.lel.design.pattern.iterator.aggregate;

import top.lel.design.pattern.iterator.ComputerCollegeIterator;
import top.lel.design.pattern.iterator.Department;

import java.util.Iterator;

/**
 * @author echo lovely
 * @date 2021/5/19 22:27
 * @description 学院
 */

public class ComputerCollege implements College {

    private final Department[] departments;

    private int position = 0;

    // max space
    private final int capacity;

    public ComputerCollege(int capacity) {
        if (capacity <= 0)
            throw new UnsupportedOperationException();
        this.capacity = capacity;
        departments = new Department[capacity];

        // init data
        this.addDepartment(new Department("JAVA", "JAVA"));
        this.addDepartment(new Department("GO", "GO"));
        this.addDepartment(new Department("PYTHON", "PYTHON"));
    }

    @Override
    public void addDepartment(Department department) {
        if (this.position < capacity) {
            this.departments[position] = department;
            position += 1;
        }
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public Iterator<Department> createIterator() {
        return new ComputerCollegeIterator(this.departments);
    }

}
