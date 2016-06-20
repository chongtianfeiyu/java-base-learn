package cn.evilcoder.Serializable;

import java.io.*;

/**
 * User: Huangshanqi
 * Date: 2016/3/24
 * Time: 15:52
 */
public class ExternalizableImp implements Externalizable{
    private int i;
    private String s;

    public ExternalizableImp() {
        System.out.println("ExternalizableImp()");
    }

    public ExternalizableImp(int i, String s) {
        System.out.println("ExternalizableImp(int i,String s)");
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //you must write s and i into
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //you must read s and i ,because default constructor does not initialization s and i
        s = (String)in.readObject();
        i  = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ExternalizableImp imp = new ExternalizableImp(111,"222");
        System.out.println("imp = " + imp);
        //write to file
        System.out.println("write to file");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("imp.out"));
        objectOutputStream.writeObject(imp);
        objectOutputStream.flush();
        //get it back
        System.out.println("get it back");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("imp.out"));
        ExternalizableImp readImp = (ExternalizableImp)objectInputStream.readObject();

        System.out.println("imp = "+readImp);
    }
}
