package cn.evilcoder.toutiao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/28.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line1 = scanner.nextLine().split(" ");
        int n = Integer.valueOf(line1[0]);
        int m = Integer.valueOf(line1[1]);
        List<String> list = new ArrayList<String>();
        for(int i = 1;i<=n;i++){
            list.add(i+"");
        }
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.get(m-1));
    }
}
