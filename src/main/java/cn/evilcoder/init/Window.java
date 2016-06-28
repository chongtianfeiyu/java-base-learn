package cn.evilcoder.init;

/**
 * The Window class model.
 *
 */
public class Window {
    /**
     *  The constructor with index number
     *
     * @param i The index number for the window.
     */
    public Window(int i) {
        System.out.println("Window(" + i + ")");
    }

    public void f(int i) {
        System.out.println("f(" + i +") in Window");
    }
}
