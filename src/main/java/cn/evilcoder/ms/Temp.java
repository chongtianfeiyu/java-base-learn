package cn.evilcoder.ms;

import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/10/10.
 */
public class Temp {
    public static int position(char c) {
        return c - 'a';
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int count[][] = new int[2][40];
            boolean[][] flag = new boolean[40][40];
            int N = Integer.valueOf(scanner.nextLine());
            String input = scanner.nextLine();
            int M = Integer.valueOf(scanner.nextLine());
            for(int i=0;i<M;i++){
                String temp = scanner.nextLine();
                char c1 = temp.charAt(0);
                char c2 = temp.charAt(1);
                flag[position(c1)][position(c2)] = true;
                flag[position(c2)][position(c1)] = true;
            }
            int now = 0 , next = 1 , ans = 0;
            for ( int i = 0; i < N; i ++ ) {
                int cur = now;
                now = next;
                next = cur;

                for ( int j = 0; j <= 30; j ++ ){
                    System.arraycopy(count[next],0,count[now], 0, count[next].length);
                }
                if ( count[now][position(input.charAt(i))] == 0 ) {
                    count[now][position(input.charAt(i))] = 1;
                }
                for ( int j = 0; j <= 26; j ++ ) {
                    if ( !flag[position(input.charAt(i))][j] && 1 + count[next][j] > count[now][position(input.charAt(i))] ) {
                        count[now][position(input.charAt(i))] = 1 + count[next][j];
                    }
                }
                for ( int j = 0; j <= 26; j ++ ){
                    if ( count[now][j] > ans ) {
                        ans = count[now][j];
                    }
                }
            }
            System.out.println(N-ans);

        }

    }
}
