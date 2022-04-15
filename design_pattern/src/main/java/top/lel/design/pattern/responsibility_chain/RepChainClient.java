package top.lel.design.pattern.responsibility_chain;

import top.lel.design.pattern.responsibility_chain.approver.*;

/**
 * @author echo lovely
 * @date 2021/6/8 09:30
 * @description your desc
 */

public class RepChainClient {

    public static void main(String[] args) {

        PurchaseRequest request = new PurchaseRequest(1, 1, 20000.00);

        Approver departmentApprover = new DepartmentApprover("王教师");
        Approver schoolMaster = new SchoolMasterApprover("李校长");
        Approver viceSchoolMaster = new ViceSchoolMasterApprover("张副校");
        Approver collegeApprover = new CollegeApprover("刘院长");

        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMaster);
        viceSchoolMaster.setApprover(schoolMaster);
        schoolMaster.setApprover(departmentApprover);

        departmentApprover.processRequest(request);

    }

}
