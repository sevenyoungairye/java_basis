package top.bitqian.responsibility_chain.approver;

import top.bitqian.responsibility_chain.PurchaseRequest;

/**
 * @author echo lovely
 * @date 2021/6/8 09:19
 * @description department
 */

public class DepartmentApprover extends Approver {
    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        Double price = request.getPrice();

        if (price <= 0) {
            throw new RuntimeException("采购不符合要求..");
        }

        if (price > 0 && price<= 5000) {
            System.out.println(super.getName() + "采购产品, id为" + request.getId() + ", 采购价格为" + request.getPrice());
        } else {
            // 交给下一个采购员处理..
            super.getApprover().processRequest(request);
        }
    }

}
