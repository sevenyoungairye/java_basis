package top.lel.design.pattern.factory.simplefactory.pizzastore.pizza;

/**
 * @author echo lovely
 * @date 2021/4/19 19:47
 * @description
 * <p>
 *     give you a pizza!
 * </p>
 */

public abstract class Pizza {

    // pizza 名称
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    // prepare step is diff
    public abstract void prepare();

    public void bake() {
        System.out.println(this.name + " baking...");
    }

    public void cut() {
        System.out.println(this.name + " cutting...");
    }

    public void box() {
        System.out.println(this.name + " boxing...");
    }

}
