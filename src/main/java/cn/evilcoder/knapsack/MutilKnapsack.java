package cn.evilcoder.knapsack;

/**
 * Created by http://www.evilcoder.cn/ on 2016/10/16.
 */
public class MutilKnapsack {
    /**
     * 有N件物品和一个容量为V的背包,每种物品都有有限件可用。
     * 第i件物品的容量是weight[i],价值是value[i]，最多可用num[i]件。
     * 求解将哪些物品装入背包可使价值总和最大
     *
     * 这个问题类似于01背包问题，所不同的是每种物品有有限件。
     * 也就是从每种物品的角度考虑，与它相关的策略已非取或不取两种，而且右取0件、取1件、取2件...，取num[i]等
     *
     * 子问题状态:f[i][j]:表示前i件物品放入容量为j的背包得到的最大价值
     * 状态转移方程:f[i][j] = max{f[i - 1][j],f[i - 1][j - k*weight[i]] + k*value[i] | 0 <= k <= num[i]}
     */

    private static final int N = 3;
    private static final int V = 5;
    private static final int[] weight = new int[]{1,2,2};
    private static final int[] value = new int[]{5,10,20};
    public static final int[] num = new int[]{1,1,2};

    public static void main(String[] args) {
        System.out.println(mutilKnapsack());
    }

    private static int mutilKnapsack() {
        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<=N;i++){
            for(int j=0;j<=V;j++){
                dp[i][j] = dp[i-1][j];
                int min = 0;
                int max = Math.min(num[i-1],V/weight[i-1]);
                for(int k=min;k<=max;k++){
                    if(j>=k*weight[i-1]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-k*weight[i-1]] + k*value[i-1]);
                    }
                }
            }
        }
        return dp[N][V];
    }
}
