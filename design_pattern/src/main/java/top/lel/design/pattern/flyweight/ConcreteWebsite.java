package top.lel.design.pattern.flyweight;

/**
 * @author echo lovely
 * @date 2021/5/6 22:10
 * @description <p>
 *
 * </p>
 */

public class ConcreteWebsite extends Website {

    // 内部状态, 网站的类型固定
    private String type;

    public ConcreteWebsite(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected void use(User user) {
        System.out.println("网站的类型: " + type + "\t 使用人: " + user.getName());
    }

}
