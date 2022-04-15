package top.lel.design.pattern.builder;

/**
 * @author echo lovely
 * @date 2021/4/24 11:44
 * @description <p>
 *     普通房子构建
 * </p>
 */

public class CommonHouse extends AbstractBuilder {
    @Override
    protected void buildBasic() {
        System.out.println("common house basic..");
    }

    @Override
    protected void buildWall() {
        System.out.println("common house wall..");
    }

    @Override
    protected void buildRoof() {
        System.out.println("common house roof..");
    }
}

