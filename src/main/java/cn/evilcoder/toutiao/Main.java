package cn.evilcoder.toutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/28.
 */
public class Main {

    public static class CharWeight{
        public char ch;
        public int weight;
        public CharWeight(char ch, int weight){
            this.ch = ch;
            this.weight = weight;
        }
    }

    public static void main(String[] argvs){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        List<String> list = new ArrayList<String>();
        for(int i=0;i<n;++i){
            list.add(scanner.nextLine());
        }
        int result = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        boolean[] firstChar = new boolean[10];
        for(String s : list) {
            firstChar[s.charAt(0) - 'A'] = true;
            int pow = 1;
            for(int i= s.length()-1;i>=0; i--){
                char ch = s.charAt(i);
                if(map.containsKey(ch)) {
                    map.put(ch, pow + map.get(ch));
                } else {
                    map.put(ch, pow);
                }
                pow *= 10;
            }
        }
        List<CharWeight> chars = new ArrayList<CharWeight>();
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            chars.add(new CharWeight(entry.getKey(), entry.getValue()));
        }
        Collections.sort(chars, new Comparator<CharWeight>(){
            public int compare(CharWeight one, CharWeight other) {
                if(one.weight == other.weight){
                    return 0;
                } else {
                    return one.weight < other.weight ? 1 : -1;
                }
            }
        });
        int index = chars.size()-1;
        for(;index>=0 && firstChar[chars.get(index).ch - 'A'];index--){
        }
        if(index > 0) {
            CharWeight temp = chars.get(index);
            chars.remove(index);
            chars.add(0, temp);
        }

        Map<Character,Integer> charDigitMap = new HashMap<Character,Integer>();
        int max = 9;
        for(CharWeight charWeight : chars) {
            charDigitMap.put(charWeight.ch, max--);
        }
        for (String s : list) {
            int pow = 1;
            for(int i=s.length()-1;i>=0;i--){
                result += charDigitMap.get(s.charAt(i))*pow;
                pow *= 10;
            }
        }

        System.out.println(result);
    }
}
