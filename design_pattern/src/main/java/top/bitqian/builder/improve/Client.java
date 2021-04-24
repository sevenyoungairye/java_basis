package top.bitqian.builder.improve;

/**
 * @author echo lovely
 * @date 2021/4/24 12:18
 * @description
 * <p>
 *     test
 * </p>
 */

public class Client {

    public static void main(String[] args) {
        // 构建高楼
        HouseDirector houseDirector = new HouseDirector(new HighBuilding());
        // 获取到构建的房子
        House house = houseDirector.constructHouse();
        System.out.println(house);

        System.out.println("~~~~~~~~~~~~~~~~~~~~");

        houseDirector.setHouseBuilder(new ThreeStoreBuilding());
        House house1 = houseDirector.constructHouse();
        System.out.println(house1);
    }

}
