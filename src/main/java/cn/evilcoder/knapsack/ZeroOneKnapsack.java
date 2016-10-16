package cn.evilcoder.knapsack;

/**
 * Created by http://www.evilcoder.cn/ on 2016/10/16.
 */
public class ZeroOneKnapsack {
    /**
     * 有N件物品和一个容量为V的背包,每种物品只有一件可用。
     * 第i件物品的容量是weight[i],价值是value[i]。
     * 求解将哪些物品装入背包可使价值总和最大
     *
     * 这是最基础的背包问题，特点是：每种物品只有一件，可以选择放或者不放
     *
     * 子问题状态:f[i][j]:表示前i件物品放入容量为j的背包得到的最大价值
     * 状态转移方程:f[i][j] = max{f[i - 1][j],f[i - 1][j - weight[i]] + value[i]}
     */

    private static final int N = 3;
    private static final int V = 5;
    private static final int[] weight = new int[]{3,2,2};
    private static final int[] value = new int[]{5,10,20};

    public static void main(String[] args) {
        System.out.println(zeroOneKnapsack());
    }
    public static int zeroOneKnapsack(){
        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<=N;i++){
            for(int j=0;j<=V;j++){
                if(j>=weight[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][V];
    }
}
