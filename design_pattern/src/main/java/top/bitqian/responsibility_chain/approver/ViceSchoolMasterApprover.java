package top.bitqian.responsibility_chain.approver;

import top.bitqian.responsibility_chain.PurchaseRequest;

/**
 * @author echo lovely
 * @date 2021/6/8 09:23
 * @description ViceSchoolMasterApprover
 */

public class ViceSchoolMasterApprover extends Approver {
    public ViceSchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        Double price = request.getPrice();
        if (price > 10000 && price <= 30000) {
            System.out.println(super.getName() + "采购产品, id为" + request.getId() + ", 采购价格为" + request.getPrice());
        } else {
            super.getApprover().processRequest(request);
        }
    }
}
