package cn.evilcoder.unionfindset;

import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/25.
 * link:http://acm.hdu.edu.cn/showproblem.php?pid=1232
 */
public class HDU1232 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String[] line1 = scanner.nextLine().split(" ");
            int N = Integer.valueOf(line1[0]);
            int M = Integer.valueOf(line1[1]);
            int[] set = new int[N+1];
            for(int i=1;i<=N;i++){
                set[i] = i;
            }
            // 刚开始的时候，有n个城镇，一条路都没有 //那么要修n-1条路才能把它们连起来
            int result = N -1;
            for (int i=0;i<M;i++){
                String[] temp = scanner.nextLine().split(" ");
                result = union(set, result, Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
            }
            System.out.println(result);
        }
    }

    private static int union(int[] set,int result, int p, int q) {
        int rootP = find(set, p);
        int rootQ = find(set, q);
        if(rootP != rootQ) {
            // 将一颗树(即一个组)变成另外一课树(即一个组)的子树
            set[rootP] = rootQ;
            return result-1;
        }
        return result;
    }

    public static int find(int[] set, int p) {
        while (p != set[p]) {
            p = set[p];
        }
        return p;
    }
}
