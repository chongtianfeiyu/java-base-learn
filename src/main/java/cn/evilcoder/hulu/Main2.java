package cn.evilcoder.hulu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/9/22.
 */
public class Main2 {
    public static class Param{
        public String name;
        public boolean required;
        public boolean mutil;
        public boolean negetive;
        public List<String> values;

        public Param(String name, boolean required, boolean mutil, boolean negetive, List<String> values) {
            this.name = name;
            this.required = required;
            this.mutil = mutil;
            this.negetive = negetive;
            this.values = values;
        }

        public List<String> generate(){
            List<String> list = new ArrayList<String>();
            if(mutil && negetive){
                List<String> par = new ArrayList<String>();
                for(int i=0;i<values.size();i++){
                    par.add(values.get(i));
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        List<Param> params = new ArrayList<Param>();
        for(int i=0;i<N;i++){
            String[] line1 = scanner.nextLine().split(" ");
            List<String> values = Arrays.asList(scanner.nextLine().split(" "));
            Collections.sort(values);
            params.add(new Param(line1[0],Integer.valueOf(line1[1])>0,
                    Integer.valueOf(line1[2])>0,Integer.valueOf(line1[3])>0,values));
        }
        handleParams(params);
    }

    private static void handleParams(List<Param> params) {
        List<String> result = new ArrayList<String>();
        Collections.sort(params, new Comparator<Param>() {
            public int compare(Param o1, Param o2) {
                return o1.name.compareTo(o2.name);
            }
        });


    }

}
