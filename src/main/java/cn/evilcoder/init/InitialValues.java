package cn.evilcoder.init;

/**
 * User: Huangshanqi
 * Date: 2016/6/28
 * Time: 21:35
 *
 * Listing all the initial value in Java for every type.
 */
public class InitialValues {
    boolean b;
    char c;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;

    public InitialValues() {
        this.i = 1000;
    }

    public void printAll() {
        System.out.println("Data type  : Initial value");
        System.out.println("boolean    :" + b);
        System.out.println("char       :" + c);
        System.out.println("short      :" + s);
        System.out.println("int        :" + i);
        System.out.println("long       :" + l);
        System.out.println("float      :" + f);
        System.out.println("double     :" + d);
        System.out.println("reference  :" + reference);
    }

    public static void main(String[] args) {
        InitialValues initialValues = new InitialValues();
        initialValues.printAll();
    }
}
