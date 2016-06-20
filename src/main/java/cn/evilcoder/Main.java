package cn.evilcoder;

import cn.evilcoder.encryption.MessageDigestAlgorithm;
import cn.evilcoder.encryption.MessageDigestUtlls;
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
        for (int i = 0; i < 255 ;i++) {
            System.out.println(String.format("%%%02X", i));
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
    }

}
