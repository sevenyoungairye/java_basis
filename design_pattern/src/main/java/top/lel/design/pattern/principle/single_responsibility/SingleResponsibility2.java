package top.lel.design.pattern.principle.single_responsibility;

/**
 * @author echo lovely
 * @date 2021/4/10 16:53
 * @description <P>
 *     拆分, 将交通工具拆分为多个类, 每个交通工具做各自的事情
 *     优点：如果每个大职责下, 有很多小的功能, 细节的地方, 比如轮船启动前, 要排水, 飞机要检修... 可以拆
 *     缺点：当功能少, 只考虑到运行时, 下面的设计显得冗余。
 * </P>
 */

public class SingleResponsibility2 {

    public static void main(String[] args) {
        // 分为三个类, 各司其职
        new RoadVehicle().run("汽车");
        new AirVehicle().run("飞机");
        new WaterVehicle().run("轮船");
    }

    static class RoadVehicle {
        public void run(String roadVehicle) {
            System.out.println(roadVehicle + "在路上运行");
        }
    }

    static class AirVehicle {
        public void run(String airVehicle) {
            System.out.println(airVehicle + "在天上运行");
        }
    }

    static class WaterVehicle {
        public void run(String waterVehicle) {
            System.out.println(waterVehicle + "在水上运行");
        }
    }

}
