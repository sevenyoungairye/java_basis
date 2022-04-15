package top.lel.design.pattern.builder.improve;

/**
 * @author echo lovely
 * @date 2021/4/24 12:21
 * @description <p>
 *     ..
 * </p>
 */

public class ThreeStoreBuilding implements HouseBuilder {
    @Override
    public void buildBasis() {
        System.out.println("三层小楼 地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("三层小楼 walls");
    }

    @Override
    public void roofed() {
        System.out.println("三层小楼 屋顶");
    }

    @Override
    public House getHouse() {
        HOUSE.setBasis("warming三层小楼");
        return HOUSE;
    }
}
