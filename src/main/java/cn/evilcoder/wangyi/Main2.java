package cn.evilcoder.wangyi;

import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/23.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        int result = handle(N);
        System.out.println(result);
    }

    private static int handle(int n) {

        int one = 0;
        int zero = one + 1;
        boolean flag = true;

        for(;one<32 && flag;one++){
            if((n & (1 << one)) != 0){
                for(zero=one+1;zero<32;zero++){
                    if((n & (1 << zero)) == 0){
                        flag = false;
                    }
                }
            }
        }
        n |= (1 << one);
        n &= (~(1 << zero));

/*        int nOnes = countOnes(n);
        int index = n+1;
        while (nOnes != countOnes(index)){
            index++;
        }
        return index;*/
        return n;
    }

    public static int countOnes(int num){
        int ones = 0;
        while (num > 0){
            ones++;
            num &= (num-1);
        }
        return ones;
    }
}
