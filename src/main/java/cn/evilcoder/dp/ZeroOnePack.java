package cn.evilcoder.dp;

/**
 * Created by huangshanqi on 2016/9/23.
 * 01背包问题,每个物品最多可以选一次
 */
public class ZeroOnePack {
    public static void main(String[] args) {
        int totalWeight = 100;
        int[] value = {100,180,320};
        int[] weight = {10,15,30};
        System.out.println(runZeroOnePack(value, weight,totalWeight, value.length));
        System.out.println(runZeroOnePack2(value,weight,totalWeight,value.length));
    }

    /**
     * 递归方式
     * @param value
     * @param weight
     * @param totalWeight
     * @param index
     * @return
     */
    private static int runZeroOnePack(int[] value, int[] weight, int totalWeight, int index) {
        if(index == 0 || totalWeight == 0){
            return 0;
        }
        if(totalWeight < weight[index-1]){
            return runZeroOnePack(value,weight,totalWeight, index-1);
        }
        return Math.max(runZeroOnePack(value,weight,totalWeight,index-1),
                value[index-1] + runZeroOnePack(value,weight,totalWeight-weight[index-1],index-1));
    }

    private static int runZeroOnePack2(int[] value, int[] weight, int totalWeight, int index) {
        // cache[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值
        int[][] cache = new int[value.length+1][totalWeight+1];
        for(int i=0;i<=value.length;i++){
            for(int w=0;w<=totalWeight;w++){
                if(i == 0 || w == 0){
                    cache[i][w] = 0;
                } else if(weight[i-1] < w){
                    cache[i][w] = Math.max(cache[i-1][w],value[i-1] + cache[i-1][w-weight[i-1]]);
                } else {
                    cache[i][w] = cache[i-1][w];
                }
            }
        }
        return cache[value.length][totalWeight];
    }

    /**
     * 部分背包问题，同一物品可以放无限次
     * @param value
     * @param weight
     * @param totalWeight
     * @param index
     * @return
     */
    public static int runPartZeroOnePack(int[] value, int[] weight, int totalWeight, int index){
        return 0;
    }
}
