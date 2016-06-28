package cn.evilcoder.init;

/**
 * User: Huangshanqi
 * Date: 2016/6/28
 * Time: 21:35
 *
 * For testing the order of initial .
 */
public class InitialOrder {
    public static void main(String[] args) {
        House house = new House();
        house.f(); // tell the construction is done.
    }

}
