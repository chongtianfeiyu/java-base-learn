package cn.evilcoder.init;

/**
 * Test class for static initial.
 */
public class StaticInitialValue {

    public static void main(String[] args) {
        System.out.println("create first Room");
        new Room();
        System.out.println("create second Room");
        new Room();
    }
}
