package cn.evilcoder;

import cn.evilcoder.hash.Time33;

public class Main {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abd";
        System.out.println(str1 + "=" + Time33.getTime33(str1));
        System.out.println(str2 + "=" + Time33.getTime33(str2));
    }

}
