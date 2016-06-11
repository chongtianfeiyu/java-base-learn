package cn.evilcoder;

import cn.evilcoder.encryption.MessageDigestAlgorithm;
import cn.evilcoder.encryption.MessageDigestUtlls;
import cn.evilcoder.hash.Time33;

public class Main {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abd";
        System.out.println(str1 + "=" + Time33.getTime33(str1));
        System.out.println(str2 + "=" + Time33.getTime33(str2));

        String md51 = MessageDigestUtlls.getMessageDigestString(str1, MessageDigestAlgorithm.SHA256);
        String md52 = MessageDigestUtlls.getMessageDigestString(str2, MessageDigestAlgorithm.SHA256);
        System.out.println(md51);
        System.out.println(md52);
    }

}
