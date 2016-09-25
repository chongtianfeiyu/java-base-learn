package cn.evilcoder.didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/23.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line1 = scanner.nextLine().split(" ");
        int n = Integer.valueOf(line1[0]);
        int sum = Integer.valueOf(line1[1]);
        String[] line2 = scanner.nextLine().split(" ");
        Integer[] array = new Integer[n];
        for(int i=0;i<n;i++){
            array[i] = Integer.valueOf(line2[i]);
        }
        Arrays.sort(array,new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtracking(result, array,new ArrayList<Integer>(),sum,0,0);
        System.out.println(result.size());
    }



    public static void backtracking(List<List<Integer>> result, Integer[] array,
                                    ArrayList<Integer> path, int sum, int cur, int index){
        if(cur == sum) {
            result.add(new ArrayList<Integer>(path));
            return;
        } else if(cur < sum){
            for(int i=index;i<array.length;i++){
                path.add(array[i]);
                backtracking(result,array,path,sum,cur + array[i],i+1);
                path.remove(path.size()-1);
            }
        }
    }


}
