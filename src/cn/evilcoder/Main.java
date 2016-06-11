package cn.evilcoder;

import cn.evilcoder.encryption.MD5;
import cn.evilcoder.hash.Time33;

public class Main {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abd";
        System.out.println(str1 + "=" + Time33.getTime33(str1));
        System.out.println(str2 + "=" + Time33.getTime33(str2));

        System.out.println(str1 + "=" + Time33.getTime33(MD5.md5(str1)));
        System.out.println(str2 + "=" + Time33.getTime33(MD5.md5(str2)));

    }

}
