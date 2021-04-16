package 第十一届研究生_java;

import java.util.Scanner;

public class _06成绩统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jihe = 0, youxiu = 0,x;
        int n = sc.nextInt(); // 考试人数
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            if (x>=60) {
                jihe++;
            }
            if (x>=85)
                youxiu++;
        }

        double r1 = jihe*100.0/n;
        double r2 = youxiu*100.0/n;
//        int ra1 = jihe*100.0/n;
//        int ra2 = youxiu*100.0/n;
        System.out.println(Math.round(r1)+"%");
        System.out.println(Math.round(r2)+"%");
        // 或者String.format("%.2f",x1)
    }
}
