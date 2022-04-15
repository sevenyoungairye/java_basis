package top.lel.design.pattern.responsibility_chain.approver;

import top.lel.design.pattern.responsibility_chain.PurchaseRequest;

/**
 * @author echo lovely
 * @date 2021/6/8 09:23
 * @description CollegeApprover
 */

public class CollegeApprover extends Approver {

    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        Double price = request.getPrice();
        if (price > 5000 && price <= 10000) {
            System.out.println(super.getName() + "采购产品, id为" + request.getId() + ", 采购价格为" + request.getPrice());
        } else {
            super.getApprover().processRequest(request);
        }
    }
}
