package top.lel.design.pattern.principle.single_responsibility;

/**
 * @author echo lovely
 * @date 2021/4/10 17:00
 * @description
 * <p>
 *     方法级别 进行单一设计原则
 * </p>
 */

public class SingleResponsibility3 {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();

        vehicle.airRun("飞机");
        vehicle.roadRun("汽车");
        vehicle.waterRun("轮船");

    }

    static class Vehicle {
        public void roadRun(String name) {
            System.out.println(name + "在陆地上run");
        }

        public void airRun(String name) {
            System.out.println(name + "在天空上run");
        }

        public void waterRun(String name) {
            System.out.println(name + "在水上run");
        }
    }

}
