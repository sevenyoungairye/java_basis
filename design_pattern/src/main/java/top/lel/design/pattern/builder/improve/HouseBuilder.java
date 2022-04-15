package top.lel.design.pattern.builder.improve;

/**
 * @author echo lovely
 * @date 2021/4/25 12:00
 * 定义建房的步骤
 */
public interface HouseBuilder {

    // 组合house
    House HOUSE = new House();

    void buildBasis();

    void buildWalls();

    void roofed();

    House getHouse();

}
