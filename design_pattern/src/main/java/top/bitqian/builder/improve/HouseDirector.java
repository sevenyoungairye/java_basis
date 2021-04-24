package top.bitqian.builder.improve;

/**
 * @author echo lovely
 * @date 2021/4/24 12:15
 * @description
 * <p>
 *     建房指挥者, 规定建房的流程
 * </p>
 */

public class HouseDirector {

    private HouseBuilder houseBuilder;

    // public HouseDirector() {}

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 构建房子
    public House constructHouse() {

        this.houseBuilder.buildBasis();
        this.houseBuilder.buildWalls();
        this.houseBuilder.roofed();

        return this.houseBuilder.getHouse();
    }

}
