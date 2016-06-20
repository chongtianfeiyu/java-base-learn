package cn.evilcoder.innotation;

/**
 * Created by huangshanqi on 2016/5/4.
 */
public class TestAnnotation {
    public static void main(String[] args) {

        UserTable userTable = new UserTable();
        userTable.setId(System.currentTimeMillis());
        userTable.setUsername("testname");
        userTable.setPassword("11111");

        System.out.println(userTable.entityInfo());
    }
}
