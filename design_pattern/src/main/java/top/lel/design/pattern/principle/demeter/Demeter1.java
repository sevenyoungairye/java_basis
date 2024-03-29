package top.lel.design.pattern.principle.demeter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2021/4/17 11:27
 * @description <p>
 * 迪米特原则:
 * 最小知道原则, 对依赖的类知道的越少越好, 依赖类只提供public方法给被依赖类访问
 * 通过方法参数, 方法返回值, 成员变量产生耦合
 * </p>
 */

public class Demeter1 {

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
        public List<CollegeEmployee> getAllEmployee() {
            List<CollegeEmployee> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) { //这里我们增加了 10 个员工到 list
                CollegeEmployee emp = new CollegeEmployee();
                emp.setId("学院员工 id= " + i);
                list.add(emp);
            }
            return list;
        }
    }

    //学校管理类
    //分析 SchoolManager 类的直接朋友类有哪些 Employee、CollegeManager
    //CollegeEmployee 不是 直接朋友 而是一个陌生类，这样违背了 迪米特法则
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
            //分析问题
            //1. 这 里 的 CollegeEmployee 不是 SchoolManager 的直接朋友
            //2. CollegeEmployee 是以局部变量方式出现在 SchoolManager
            //3. 违反了迪米特法则
            //获取到学院员工
            List<CollegeEmployee> list1 = sub.getAllEmployee();
            System.out.println("------------学院员工------------");
            for (CollegeEmployee e : list1) {
                System.out.println(e.getId());
            }
            //获取到学校总部员工
            List<Employee> list2 = this.getAllEmployee();
            System.out.println("------------学校总部员工------------");
            for (Employee e : list2) {
                System.out.println(e.getId());
            }
        }
    }

}
