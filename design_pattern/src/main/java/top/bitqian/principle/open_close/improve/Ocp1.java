package top.bitqian.principle.open_close.improve;

/**
 * @author echo lovely
 * @date 2021/4/17 10:13
 * @description
 * <p>
 *     开闭原则实现demo
 * </p>
 */

public class Ocp1 {

    public static void main(String[] args) {

        new GraphicEditor(new Circle()).drawShape();
        new GraphicEditor(new Triangle()).drawShape();

    }
    // 调用方
    static class GraphicEditor {

        private final Shape shape;

        GraphicEditor(Shape shape) {
            this.shape = shape;
        }

        /**
         * draw sth...
         */
        void drawShape() {
            // 这里可以不用改变了, 只要改变子类的实现细节, 就可画出不同的形状..
            shape.shapeDetail();
        }

    }

    // 提供方
    static abstract class Shape {
        Integer type;

        /**
         * 提供抽象
         */
        abstract void shapeDetail();
    }

    static class Circle extends Shape {
        Circle() {
            super.type = 1;
        }

        @Override
        void shapeDetail() {
            System.out.println("draw circle...");
        }
    }

    static class Triangle extends Shape {
        Triangle() {
            super.type = 2;
        }

        @Override
        void shapeDetail() {
            System.out.println("draw triangle...");
        }
    }

}
