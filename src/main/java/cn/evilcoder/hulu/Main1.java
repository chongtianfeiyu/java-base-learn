package cn.evilcoder.hulu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/22.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            List<String> inputs = new ArrayList<String>();
            for(String s : input.split(" ")){
                inputs.add(s);
            }
            String result = combination(inputs);
            System.out.println(result);
        }
    }

    public static String combination(List<String> inputs) {
        String result = "";
        Collections.sort(inputs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        Map<String,Boolean> occur = new HashMap<String, Boolean>();
        for(String str : inputs){
            occur.put(str, true);
        }
        for(String str : inputs) {
            if(isConcat(str, true, occur)){
                return str;
            }
        }
        return result;
    }

    private static boolean isConcat(String str, boolean first, Map<String, Boolean> occur) {
        if (occur.containsKey(str) && !first) {
            return occur.get(str);
        }
        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            if (occur.containsKey(left) && occur.get(left) && occur.containsKey(right) && occur.get(right)
                    && (isConcat(right, false, occur) || isConcat(left, false, occur))) {
                return true;
            }
        }

        occur.put(str, false);
        return false;
    }
}
