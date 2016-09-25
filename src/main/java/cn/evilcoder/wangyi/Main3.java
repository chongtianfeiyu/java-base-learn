package cn.evilcoder.wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by huangshanqi on 2016/9/23.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int result = handle(string);
        System.out.println(result);
    }

    private static int handle(String string) {
        Set<String> set = new HashSet<String>();
        int len = string.length();
        for(int i=0;i<len;i++){
            for(int j=i+2;j<=len;j++) {
                String sub = string.substring(i,j);
                if(check(sub)){
                    set.add(sub);
                }
            }
        }
        return set.size();
    }
    public static boolean check(String s){
        int len = s.length();
        return len%2==0 && s.substring(0,len/2).equals(s.substring(len/2));
    }
}
