package cn.evilcoder.ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/10/10.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        List<Integer> list = new ArrayList<Integer>();
        String[] line2 = scanner.nextLine().split(" ");
        int odd = 0;
        int even = 0;
        for(String str : line2) {
            int temp = Integer.valueOf(str);
            if(temp %2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println(Math.abs(even - odd));
    }
}
