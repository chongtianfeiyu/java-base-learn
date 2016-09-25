package cn.evilcoder.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by huangshanqi on 2016/9/24.
 */
public class MaxSeq {

    /**
     * 最大子序列：子序列的和最大，需要连续
     * 比如array={5,-6,4,2}的最大子序列是{4,2}，它的和是6
     * @param array
     * @return
     */
    public static List<Integer> largeSeq(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int maxBegin = 0;
        int maxEnd = 0;
        for(int i=0;i<array.length;i++){
            curSum += array[i];
            if(curSum > maxSum) {
                maxSum = curSum;
                maxEnd = i;
            } else if (curSum < 0) {
                curSum = 0;
                maxBegin = i+1;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=maxBegin;i<=maxEnd;i++){
            result.add(array[i]);
        }
        System.out.println("largeSeq:from " + maxBegin + " to " + maxEnd + ",max sum= " + maxSum);
        return result;
    }

    /**
     * 最长递增序列：非连续
     * 比如array={1,5,8,2,3,4}的最长递增子序列是1,2,3,4
     * @param array
     * @return
     */
    public static List<Integer> largeIncreaseSeq(int[] array) {
        // 记录[0,i] 的最大递增长度
        int[] maxIncrease = new int[array.length];
        // 记录i的前一个递增序列下标
        int[] preIndex = new int[array.length];
        Arrays.fill(maxIncrease, 1);
        Arrays.fill(preIndex, -1);

        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 1;i<array.length;++i){
            for(int j=i-1;j>=0;--j) {
                if(array[i] > array[j] && maxIncrease[j] + 1 > maxIncrease[i]) {
                    maxIncrease[i] = maxIncrease[j] + 1;
                    preIndex[i] = j;
                    if (maxIncrease[i] > maxLen) {
                        maxLen = maxIncrease[i];
                        maxEnd = i;
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(maxIncrease));
//        System.out.println(Arrays.toString(preIndex) + maxEnd);

        List<Integer> increaseSeq = new ArrayList<Integer>();
        while (maxEnd >= 0) {
            increaseSeq.add(0,array[maxEnd]);
            maxEnd = preIndex[maxEnd];
        }
        System.out.println("largeIncreSeq:" + increaseSeq);
        return increaseSeq;
    }

    /**
     * 最长公共字串，必须是连续的
     * @param str1
     * @param str2
     * @return
     */
    public static String largeCommmentString(String str1, String str2) {
        int[][] cache = new int[str1.length()][str2.length()];
        int maxLen = 0;
        int maxEnd = 0;
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                if(str1.charAt(i) == str2.charAt(j)) {
                    if(i == 0 || j == 0){
                        cache[i][j] = 1;
                    } else {
                        cache[i][j] = cache[i-1][j-1] + 1;
                    }
                    if(cache[i][j] > maxLen) {
                        maxEnd = i;
                        maxLen = cache[i][j];
                    }
                }
            }
        }
        String result = str1.substring(maxEnd-maxLen+1, maxEnd+1);
        System.out.println("largeCommentString:" + result);
        return result;
    }

    /**
     * 最大公共子序列，非必须连续
     * 比如ADE和ABCDE的最长公共子序列是ADE
     * @param str1
     * @param str2
     * @return
     */
    public static String largeCommentSeq(String str1, String str2) {
        int[][] cache = new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<=str1.length();++i){
            for(int j=1;j<=str2.length();++j){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    cache[i][j] = cache[i-1][j-1] + 1;
                } else {
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        for(int[] arr : cache) {
            System.out.println(Arrays.toString(arr));
        }
        int maxLen = cache[str1.length()][str2.length()];
        StringBuilder sb = new StringBuilder();
        int index1 = str1.length();
        int index2 = str2.length();
        while (maxLen > 0) {
            if(cache[index1][index2] != cache[index1-1][index2-1]) {
                if(cache[index1][index2-1] == cache[index1-1][index2]) {
                    // 两字符相等，为公共字符
                    sb.insert(0,str1.charAt(index1-1));
                    index1--;
                    index2--;
                    maxLen--;
                } else {
                    // 取两者中较长者作为A和B的最长公共子序列
                    if(cache[index1-1][index2] >cache[index1][index2-1]) {
                        --index1;
                    } else {
                        --index2;
                    }
                }
            } else {
                --index1;
                --index2;
            }
        }
        System.out.println("largeCommentSeq:" + sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,-3,4,2};
        largeSeq(array);
        int[] array2 = new int[]{1,5,8,2,3,4};
        largeIncreaseSeq(array2);

        String str1 = "fsdfsd20160924111gdfgsgdf";
        String str2 = "asdfasga20160924111lajflajf";
        largeCommmentString(str1, str2);

        largeCommentSeq("ABCBDAB", "BCDB");
    }
}
