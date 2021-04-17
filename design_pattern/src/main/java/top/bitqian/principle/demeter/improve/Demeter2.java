package top.bitqian.principle.demeter.improve;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/4/17 11:42
 * @description
 * <p>
 *     高内聚, 最少知道原则
 * </p>
 */

public class Demeter2 {

    public static void main(String[] args) {
        //创建了一个 SchoolManager 对象
        SchoolManager schoolManager = new SchoolManager();
        //输出学院的员工 id 和 学校总部的员工信息
        schoolManager.printAllEmployee(new CollegeManager());
    }

    //学校总部员工类
    @Data
    static class Employee {
        private String id;
    }

    //学院的员工类
    @Data
    static class CollegeEmployee {
        private String id;
    }

    //管理学院员工的管理类
    static class CollegeManager {
        //返回学院的所有员工
        private List<CollegeEmployee> setAllEmployee() {
            List<CollegeEmployee> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) { //这里我们增加了 10 个员工到 list
                CollegeEmployee emp = new CollegeEmployee();
                emp.setId("学院员工 id= " + i);
                list.add(emp);
            }
            return list;
        }

        // 将获取员工方法抽取到自己的类
        public void getAllEmployee() {
            List<CollegeEmployee> list1 = setAllEmployee();
            System.out.println("------------学院员工------------");
            for (CollegeEmployee e : list1) {
                System.out.println(e.getId());
            }
        }

    }

    //学校管理类
    static class SchoolManager {
        //返回学校总部的员工
        public List<Employee> getAllEmployee() {
            List<Employee> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) { //这里我们增加了 5 个员工到 list
                Employee emp = new Employee();
                emp.setId("学校总部员工 id= " + i);
                list.add(emp);
            }
            return list;
        }

        //该方法完成输出学校总部和学院员工信息(id)
        void printAllEmployee(CollegeManager sub) {

            // 抽取..
            sub.getAllEmployee();

            //获取到学校总部员工
            List<Employee> list2 = this.getAllEmployee();
            System.out.println("------------学校总部员工------------");
            list2.forEach(r -> System.out.println(r.getId()));
        }
    }

}
