package top.lel.design.pattern.principle.dependency_inversion.improve;

/**
 * @author echo lovely
 * @date 2021/4/11 10:48
 * @description
 * <p>
 *     三种常用面向接口编程, 传参方式不同
 * </p>
 */

public class DemoInversion3 {

    public static void main(String[] args) {

        Case3.IOpenAndClose openAndClose = new Case3.OpenAndClose();
        openAndClose.setITv(new Case3.Tcl());
        openAndClose.open();

        Case2.IOpenAndClose openAndClose1 = new Case2.OpenAndClose(new Case2.Tcl());
        openAndClose1.open();

        Case1.IOpenAndClose openAndClose2 = new Case1.OpenAndClose();
        openAndClose2.open(new Case1.Tcl());
    }

    /**
     * 接口参数
     */
    static class Case1 {

        /**
         * 电视接口 用于播放
         */
        interface ITv {
            void play();
        }

        static class Tcl implements ITv {
            @Override
            public void play() {
                System.out.println("tcl playing...");
            }
        }

        /**
         * 开启 或者 关闭电视
         */
        interface IOpenAndClose {
            // 接口传参
            void open(ITv tv);
        }

        /**
         * 用来打开, 或者关闭电视 实现播放功能
         */
        static class OpenAndClose implements IOpenAndClose {

            public OpenAndClose() {

            }

            @Override
            public void open(ITv tv) {
                tv.play();
            }
        }

    }

    /**
     * 构造参数
     */
    static class Case2 {

        interface ITv {
            void play();
        }

        static class Tcl implements ITv {
            @Override
            public void play() {
                System.out.println("tcl playing...");
            }
        }

        interface IOpenAndClose {
            void open();
        }

        static class OpenAndClose implements IOpenAndClose {

            private final Case2.ITv iTv;

            // construct init..
            public OpenAndClose(Case2.ITv iTv) {
                this.iTv = iTv;
            }

            @Override
            public void open() {
               iTv.play();
            }
        }

    }

    /**
     * setter参数
     */
    static class Case3 {

        interface ITv {
            void play();
        }

        static class Tcl implements Case3.ITv {
            @Override
            public void play() {
                System.out.println("tcl playing...");
            }
        }

        interface IOpenAndClose {

            void open();

            void setITv(ITv iTv);
        }

        static class OpenAndClose implements Case3.IOpenAndClose {

            private ITv iTv;

            // init by setter...
            public void setITv(ITv iTv) {
                this.iTv = iTv;
            }

            @Override
            public void open() {
                if (iTv != null) {
                    iTv.play();
                } else {
                    System.out.println("there is no tv available...");
                }
            }
        }
    }


}
