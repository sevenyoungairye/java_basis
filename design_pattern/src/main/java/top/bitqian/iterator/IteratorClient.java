package top.bitqian.iterator;

import top.bitqian.iterator.aggregate.College;
import top.bitqian.iterator.aggregate.ComputerCollege;
import top.bitqian.iterator.aggregate.InfoCollege;

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
