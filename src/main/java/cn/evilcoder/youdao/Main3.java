package cn.evilcoder.youdao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/22.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] str1 = scanner.nextLine().split(" ");
            String[] str2 = scanner.nextLine().split(" ");
            int n = Integer.valueOf(str1[0]);
            int a = Integer.valueOf(str1[1]);
            int b = Integer.valueOf(str1[2]);
            int[] hp = new int[n];
            for(int i=0;i<n;i++){
                hp[i] = Integer.valueOf(str2[i]);
            }
            handleInput(hp,a,b);
        }
    }

    private static void handleInput(int[] hp, int a, int b) {
        int min = Integer.MAX_VALUE;
        List<Integer> path = new ArrayList<Integer>();
        for(int i=1;i<hp.length;i++){
            List<Integer> temp = fromShot(hp,a,b,i,new ArrayList<Integer>());
            if(temp.size() < min) {
                path = temp;
                min = path.size();
            }
        }
        System.out.println(path.size());
        StringBuilder sb = new StringBuilder();
        for (int num : path){
            sb.append(num+1).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
    public static List<Integer> fromShot(int[] hp, int a, int b, int index, List<Integer> path){

        if(success(hp)){
            return path;
        }

        int min = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<Integer>();


        for(int i=index;i<hp.length;i++){
            hp[i] -= a;
            if(i>0){
                hp[i-1] -= b;
            }
            if(i<hp.length-1){
                hp[i+1] -= b;
            }
            path.add(i);
            List<Integer> temp = fromShot(hp,a,b,i+1,new ArrayList<Integer>(path));
            if(temp.size() < min) {
                result = temp;
                min = result.size();
            }
        }
        return result;
    }

    private static boolean success(int[] hp) {
        for(int i : hp){
            if(i >= 0){
                return false;
            }
        }
        return true;
    }
}
