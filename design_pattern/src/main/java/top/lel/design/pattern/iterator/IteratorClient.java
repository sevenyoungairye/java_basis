package top.lel.design.pattern.iterator;

import top.lel.design.pattern.iterator.aggregate.College;
import top.lel.design.pattern.iterator.aggregate.ComputerCollege;
import top.lel.design.pattern.iterator.aggregate.InfoCollege;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/5/19 23:00
 * @description test..
 */

public class IteratorClient {

    public static void main(String[] args) {

        List<College> collegeList = new ArrayList<>();
        ComputerCollege computerCollege = new ComputerCollege(5);
        computerCollege.addDepartment(new Department("ha", "ha"));
        computerCollege.addDepartment(new Department("ha", "ha"));
        computerCollege.addDepartment(new Department("ha", "ha"));
        computerCollege.addDepartment(new Department("ha", "ha"));
        collegeList.add(computerCollege);

        collegeList.add(new InfoCollege());

        new OutputImpl(collegeList).outputCollege();

    }

}
