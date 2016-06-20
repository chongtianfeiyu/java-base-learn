package cn.evilcoder.Serializable;

import java.io.*;

/**
 * User: Huangshanqi
 * Date: 2016/3/24
 * Time: 16:35
 */
public class AddReadWriteImp implements Serializable{
    private String username;
    private transient String password;

    public AddReadWriteImp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username+":"+password;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        System.out.println("using readObject()");
        stream.defaultReadObject();
        password = (String)stream.readObject();

    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        System.out.println("using writeObject()");
        stream.defaultWriteObject();
        stream.writeObject(password);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AddReadWriteImp imp = new AddReadWriteImp("evilcoder","abcdefgh");
        System.out.println("imp = " + imp);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("imp.out"));
        objectOutputStream.writeObject(imp);
        objectOutputStream.flush();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("imp.out"));
        AddReadWriteImp readImp = (AddReadWriteImp)objectInputStream.readObject();

        System.out.println("imp = "+readImp);
    }
}
