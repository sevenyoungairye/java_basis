package top.lel.design.pattern.principle.open_close;

/**
 * @author echo lovely
 * @date 2021/4/17 10:04
 * @description
 * <p>
 *     ocp 开闭原则...
 *     <li>提供方可扩展, 调用方关闭, 调用方不修改</li>
 * </p>
 */

public class Ocp {

    public static void main(String[] args) {

        new GraphicEditor(new Circle());
        new GraphicEditor(new Triangle());
    }

    // 调用方
    static class GraphicEditor {

        private final Shape shape;

        GraphicEditor(Shape shape) {
            this.shape = shape;
            this.drawCircle();
        }

        void drawCircle() {
            // fixme: 如果我有很多形状, 这里要加很多判断
            if (shape.type == 1) {
                System.out.println("draw circle...");
            }

            if (shape.type == 2) {
                System.out.println("draw Triangle...");
            }
        }

    }

    // 提供方
    static class Shape {
        Integer type;
    }

    static class Circle extends Shape {
        Circle() {
            super.type = 1;
        }
    }

    static class Triangle extends Shape {
        Triangle() {
            super.type = 2;
        }
    }

}
