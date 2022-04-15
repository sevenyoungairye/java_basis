package top.lel.design.pattern.responsibility_chain.approver;

import top.lel.design.pattern.responsibility_chain.PurchaseRequest;

/**
 * @author echo lovely
 * @date 2021/6/8 09:24
 * @description SchoolMaster
 */

public class SchoolMasterApprover extends Approver {
    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        Double price = request.getPrice();
        if (price > 30000) {
            System.out.println(super.getName() + "采购产品, id为" + request.getId() + ", 采购价格为" + request.getPrice());
        } else {
            // 这里要设置采购价格最低的 形成闭环..
            super.getApprover().processRequest(request);
        }
    }
}
