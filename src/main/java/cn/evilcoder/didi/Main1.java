package cn.evilcoder.didi;

import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/23.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String[] line1 = scanner.nextLine().split(" ");
            int m = Integer.valueOf(line1[0]);
            int n = Integer.valueOf(line1[1]);
            String result = convert(m,n);
            System.out.println(result);
        }
    }

    private static String convert(int num, int n) {
        StringBuilder sb = new StringBuilder();
        if(num < 0){
            num = ((-1 * num)^((1 << 31)-1)) + 1;
        }

        if(num/n != 0){
            sb.insert(0,convert(num/n,n));
        }
        sb.append(showChar(num%n));
        return sb.toString();
    }
    public static String showChar(int num) {
        if(9 < num && num <=16) {
            return "" + (char)(num-10 + 65);
        } else {
            return "" + num;
        }
    }
}
