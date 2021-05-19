package top.bitqian.iterator;

import top.bitqian.iterator.aggregate.College;

import java.util.Iterator;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/5/19 22:52
 * @description 聚合college, 输出学院和系
 */

public class OutputImpl {

    private final List<College> collegeList;

    public OutputImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    public void outputCollege() {

        /*while (collegeIterator.hasNext()) {
            College college = collegeIterator.next();
            System.out.println("学院: " + college.getName());

            Iterator<Department> departmentIterator = college.createIterator();
            this.outputDepartment(departmentIterator);

            System.out.println("====================");
        }*/

        for (College college : collegeList) {
            System.out.println("学院: " + college.getName());

            Iterator<Department> departmentIterator = college.createIterator();
            this.outputDepartment(departmentIterator);

            System.out.println("====================");
        }
    }

    private void outputDepartment(Iterator<Department> departmentIterator) {
        while (departmentIterator.hasNext()) {
            System.out.println("遍历学院下的院系: " + departmentIterator.next());
        }
    }

}
