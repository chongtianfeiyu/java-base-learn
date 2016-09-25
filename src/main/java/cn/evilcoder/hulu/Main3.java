package cn.evilcoder.hulu;

import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/22.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        for(int game = 0;game < N;game++){
            String[] strs = scanner.nextLine().split(" ");
            int n = Integer.valueOf(strs[0]);
            int m = Integer.valueOf(strs[1]);
            int l = Integer.valueOf(strs[2]);
            int s = Integer.valueOf(strs[3]);
            char[][] matrix = new char[n][m];
            for(int row = 0;row<n;row++){
                String tempStr = scanner.nextLine();
                for(int col=0;col<m;col++){
                    matrix[row][col] = tempStr.charAt(col);
                }
            }
            int[][] star = new int[n][m];

            System.out.println("Test Case " + game + ": " + countStep(matrix,n,m,l,s));
        }
    }

    private static int countStep(char[][] matrix, int n, int m, int l, int s) {
        int step = 1;


        return step;
    }
}
