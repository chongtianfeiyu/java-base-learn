package cn.evilcoder.ms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by huangshanqi on 2016/10/10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        String input = scanner.nextLine();
        int M = Integer.valueOf(scanner.nextLine());
        List<String> adjs = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        for(int i=0;i<M;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(scanner.nextLine());
            set.add(sb.toString());
            set.add(sb.reverse().toString());
        }
        adjs.addAll(set);
        int result = handle(N,input,M,adjs);
        System.out.println(result);
    }

    private static int handle(int n, String input, int m, List<String> adjs) {
        if(isFinish(input, adjs)) {
            return n - input.length();
        }
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<input.length();i++){
            sb.setLength(0);
            sb.append(input);
            min = Math.min(min, handle(n, sb.deleteCharAt(i).toString(), m,adjs));
        }
        return min;
    }

    public static boolean isFinish(String input, List<String> adjs) {
        for(String str : adjs) {
            if(input.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
