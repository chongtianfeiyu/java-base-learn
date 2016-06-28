package cn.evilcoder.init;

/**
 *
 */
public class NonStaticBlock {
    Window window1;
    Window window2;
    {
        window1 = new Window(1);
        window2 = new Window(2);
        System.out.println("execute non static block.");
    }

    public NonStaticBlock() {
        System.out.println("NonStaticBlock()");
    }
}
