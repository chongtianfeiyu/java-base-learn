package cn.evilcoder.toutiao;

import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/28.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = handle(input);
        System.out.println(result);
    }

    private static int handle(String input) {
        int result = 0;
        for(int i=1;i<=input.length();i++){
            if(input.equals(input.substring(i, input.length()) + input.substring(0,i))){
                result++;
            }
        }

        return result;
    }
}
