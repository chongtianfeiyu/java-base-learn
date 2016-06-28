package cn.evilcoder;

import cn.evilcoder.encryption.AES128Impl;
import cn.evilcoder.encryption.AESExceptions;
import cn.evilcoder.encryption.MessageDigestAlgorithm;
import cn.evilcoder.encryption.MessageDigestUtlls;
import cn.evilcoder.init.NonStaticBlock;
import cn.evilcoder.init.StaticBlock;
import cn.evilcoder.json.JsonUtils;
import cn.evilcoder.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.script.javascript.JSAdapter;

public class Main {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abd";
        String md51 = MessageDigestUtlls.getMessageDigestString(str1, MessageDigestAlgorithm.SHA256);
        String md52 = MessageDigestUtlls.getMessageDigestString(str2, MessageDigestAlgorithm.SHA256);
        System.out.println("md51=" + md51);
        System.out.println("md52=" + md52);

        String content = "evilcoder";
        String sk = "123456789123456789";
        try {
            String encryptContent = AES128Impl.encrypt(content, sk);
            String decryptContent = AES128Impl.decrypt(encryptContent, sk);
            System.out.println("original-content = " + content);

            System.out.println("encrypt-content = " + encryptContent);
            System.out.println("decrypt-content = " + decryptContent);
        } catch (AESExceptions.EncryptServiceException e) {
            e.printStackTrace();
        } catch (AESExceptions.DecryptServiceException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <= 17; i++) {
            System.out.println(i + "=" + Integer.toHexString(i));
        }

        Person person = new Person();
        person.setAge(20);
        person.setName("evilcoder.cn");
        try {
            String personStr = JsonUtils.toJsonPrettyString(person);
            System.out.println(JsonUtils.toJsonPrettyString(person));
            System.out.println(JsonUtils.fromJsonString(personStr, Person.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

       new NonStaticBlock();
       new NonStaticBlock();
    }



}
