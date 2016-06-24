package cn.evilcoder.serializable;

import java.io.*;

/**
 * User: Huangshanqi
 * Date: 2016/3/24
 * Time: 15:18
 */
public class SerializableImp implements Serializable{

    private int n;

    public SerializableImp(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableImp imp = new SerializableImp(111);
        System.out.println("imp = " + imp);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("imp.out"));
        objectOutputStream.writeObject(imp);
        objectOutputStream.flush();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("imp.out"));
        SerializableImp readImp = (SerializableImp)objectInputStream.readObject();

        System.out.println("imp = "+readImp);

    }
}
