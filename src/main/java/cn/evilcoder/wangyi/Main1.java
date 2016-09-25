package cn.evilcoder.wangyi;

import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/23.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line1 = scanner.nextLine().split(" ");
        int A = Integer.valueOf(line1[0]);
        int B = Integer.valueOf(line1[1]);
        int C = Integer.valueOf(line1[2]);
        int result = minSum(A,B,C);
        System.out.println(result);
    }

    private static int minSum(int a, int b, int c) {
        int cCount = count(c);
        int minCount = Math.abs(count(b) - cCount);
        int min = b;
        for(int i=b-1;i>=a;i--){
            int temp = Math.abs(cCount-count(i));
            if(temp <= minCount){
                minCount = temp;
                min = i;
            }
        }
        return min;
    }
    public static int count(int num){
        int result = 0;
        while (num > 0){
            result += num%10;
            num /= 10;
        }
        return result;
    }
}
