package top.lel.design.pattern.responsibility_chain;

/**
 * @author echo lovely
 * @date 2021/6/8 08:43
 * @description 采购请求
 */

public class PurchaseRequest {

    private Integer id;

    private Integer type;

    private Double price;

    public PurchaseRequest(Integer id, Integer type, Double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }
}
