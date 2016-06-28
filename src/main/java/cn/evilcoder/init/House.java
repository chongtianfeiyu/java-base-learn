package cn.evilcoder.init;

/**
 * The House model.
 * An house contains many Windows.
 */
public class House {
    Window window1 = new Window(1); // before constructor

    public House() {
        // in constructor
        System.out.println("House()");
        window3 = new Window(4); // reset window3 to window(4)
    }

    Window window2 = new Window(2);
    public void f() {
        System.out.println("f()");
    }
    Window window3 = new Window(3);
}
