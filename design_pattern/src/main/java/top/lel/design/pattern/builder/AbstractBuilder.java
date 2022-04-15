package top.lel.design.pattern.builder;

/**
 * @author echo lovely
 * @date 2021/4/24 11:40
 * @description
 * <p>
 *     考虑建房子，定义接口, 实现
 * </p>
 */

public abstract class AbstractBuilder {

    protected abstract void buildBasic();
    protected abstract void buildWall();
    protected abstract void buildRoof();

    // 构建顺序
    public void builder() {
        buildBasic();
        buildWall();
        buildRoof();
    }
}
