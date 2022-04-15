package top.lel.design.pattern.principle.single_responsibility;

/**
 * @author echo lovely
 * @since 2021/4/10 16:45
 * @description
 * <p>
 *     单一设计原则：
 *     <li>降低类的复杂度, 一个类只维护一项职责</li>
 *     <li>提高类的可读性, 可维护性</li>
 *     <li>降低变更引起的风险</li>
 *     <li>
 *     usual, 一般遵守单一设计原则,
 *     只有逻辑足够简单, 才能<label>代码级别</label>违反单一设计原则,
 *     如果方法足够少, 可以在方法级别保持单一职责原则。
 *     </li>
 * </p>
 */

public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("火车");
        vehicle.run("汽车");
        // 飞机在陆地上不合理..
        vehicle.run("飞机");
    }

    /**
     * vehicle, there is...
     */
    static class Vehicle {
        public void run(String vehicle) {
            System.out.println(vehicle + " 在陆地上跑.....");
        }
    }
}

