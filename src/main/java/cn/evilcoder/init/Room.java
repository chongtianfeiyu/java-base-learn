package cn.evilcoder.init;

/**
 * The room object model.
 * A room can contains many windows.
 */
public class Room {
    Window window1 = new Window(1);

    public Room() {
        System.out.println("Room()");
        window3.f(1000);
    }

    static Window window2 = new Window(2);

    static Window window3 = new Window(3);
}
