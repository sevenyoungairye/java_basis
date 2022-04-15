package top.lel.design.pattern.composite;

/**
 * @author echo lovely
 * @date 2021/5/4 16:24
 * @description a client
 * jdk源码见HashMap
 */

public class SchoolManager {

    public static void main(String[] args) {
        OrganizationComponent component = new University("Peking University", "top2 of China");

        OrganizationComponent infoCom = new College("信息学院", "==信息学院==");
        OrganizationComponent computerCom = new College("计算机学院", "==计算机学院==");

        // 收集所有College
        component.add(infoCom);
        component.add(computerCom);
        // 打印所有university的信息
        // component.print();

        OrganizationComponent infoDep = new Department("光零2000信息系", "info");
        OrganizationComponent infoDep1 = new Department("光零2019信息系", "00系");
        // 收集所有Department
        infoCom.add(infoDep);
        infoCom.add(infoDep1);


        OrganizationComponent computerDep = new Department("计算机2000系", "computer系");
        OrganizationComponent computerDep1 = new Department("计算机2019信息系", "computer2019系");
        computerCom.add(computerDep);
        computerCom.add(computerDep1);

        component.print();
    }

}
