package top.lel.design.pattern.responsibility_chain.approver;

import top.lel.design.pattern.responsibility_chain.PurchaseRequest;

/**
 * @author echo lovely
 * @date 2021/6/8 09:04
 * @description 采购人
 */

public abstract class Approver {

    // 下一个职责链..
    private Approver approver;

    // 采购员姓名
    private String name;

    public String getName() {
        return name;
    }

    public Approver(String name) {
        this.name = name;
    }

    /**
     * 动态的设置采购人
     */
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public Approver getApprover() {
        return approver;
    }

    /**
     * 处理采购请求
     * @param request req
     */
    public abstract void processRequest(PurchaseRequest request);
}
