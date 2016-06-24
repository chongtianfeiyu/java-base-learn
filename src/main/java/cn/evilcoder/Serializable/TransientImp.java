package cn.evilcoder.serializable;

import java.io.*;

/**
 * User: Huangshanqi
 * Date: 2016/3/24
 * Time: 16:22
 */
public class TransientImp implements Serializable {

    private String username;
    private transient String password;

    public TransientImp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username+":"+password;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TransientImp imp = new TransientImp("evilcoder","abcdefgh");
        System.out.println("imp = " + imp);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("imp.out"));
        objectOutputStream.writeObject(imp);
        objectOutputStream.flush();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("imp.out"));
        TransientImp readImp = (TransientImp)objectInputStream.readObject();

        System.out.println("imp = "+readImp);
    }
}
