package top.lel.design.pattern.builder.improve;

/**
 * @author echo lovely
 * @date 2021/4/24 12:04
 * @description <p>
 *     ..
 * </p>
 */

public class HighBuilding implements HouseBuilder {

    @Override
    public void buildBasis() {
        System.out.println("HighBuilding buildBasis");
    }

    @Override
    public void buildWalls() {
        System.out.println("HighBuilding buildWalls");
    }

    @Override
    public void roofed() {
        System.out.println("HighBuilding roofed");
    }

    @Override
    public House getHouse() {
        HOUSE.setBasis("高楼地基..");
        return HOUSE;
    }

}
