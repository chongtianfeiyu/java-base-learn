package cn.evilcoder.youdao;

import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/22.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str1 = scanner.nextLine().split(" ");
        int N = Integer.valueOf(str1[0]);
        int M = Integer.valueOf(str1[1]);
        int t1 = Integer.valueOf(str1[2]);
        int t2 = Integer.valueOf(str1[3]);
        int[][] meet = new int[M][2];
        for(int i = 0;i<M;i++){
            String[] temp = scanner.nextLine().split(" ");
            meet[i][0] = Integer.valueOf(temp[0]);
            meet[i][1] = Integer.valueOf(temp[1]);
        }
        int min = countMin(meet,N,t1,t2);
        System.out.println(min);

    }

    private static int countMin(int[][] meet, int n, int t1, int t2) {
        return 0;
    }
}
