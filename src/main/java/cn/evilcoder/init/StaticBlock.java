package cn.evilcoder.init;

/**
 *
 */
public class StaticBlock {

    static {
        i = 1000;
        System.out.println("execute static block");
    }
   public static int i;
}
