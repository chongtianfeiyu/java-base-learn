package cn.evilcoder.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by huangshanqi on 2016/10/10.
 */
public class Main3 {
    public static class Stu{
        public long number;
        public long arriveTime;
        public Map<Integer, Long> tasks;
        public long totalTime;

        public Stu() {
        }

        public Stu(long number, long arriveTime, Map<Integer, Long> tasks, long totalTime) {
            this.number = number;
            this.arriveTime = arriveTime;
            this.tasks = tasks;
            this.totalTime = totalTime;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        int N = Integer.valueOf(line1[0]);
        int M = Integer.valueOf(line1[1]);
        int K = Integer.valueOf(line1[2]);
        List<Stu> stus = new ArrayList<Stu>();
        for(int i=0;i<N;i++){
            Stu stu = new Stu();
            stu.number = scanner.nextLong();
            stu.arriveTime = scanner.nextLong();
            stu.tasks = new HashMap<Integer, Long>();
            int taskNum = scanner.nextInt();
            while (taskNum-->0) {
                stu.tasks.put(scanner.nextInt(), scanner.nextLong());
            }
            stus.add(stu);
        }
        handle(N,M,K,stus);
        for(Stu stu : stus) {
            System.out.println(stu.totalTime);
        }
    }

    private static void handle(int n, int m, int k, List<Stu> stus) {
        for(int office = 1;office <= m;office++) {
            List<Stu> officeStus = new ArrayList<Stu>();
            for(Stu stu : stus) {
                if(stu.tasks.containsKey(office)){
                    officeStus.add(stu);
                }
            }
            if(!officeStus.isEmpty()) {
                int add = 0;
                Collections.sort(officeStus, new Comparator<Stu>() {
                    public int compare(Stu o1, Stu o2) {
                        if(o1.arriveTime < o2.arriveTime || (o1.arriveTime == o2.arriveTime && o1.number < o2.number)) {
                            return 1;
                        }
                        return -1;
                    }
                });
                for(Stu stu : officeStus) {
                    add += (k + stu.tasks.get(office));
                    stu.arriveTime += add;
                }
            }
            int add = 0;
            while (!officeStus.isEmpty()) {

                add += (k + officeStus.get(0).tasks.get(office));

            }


        }
    }
}
