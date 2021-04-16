package 第十届研究生_java;

import java.util.Scanner;

public class _02字串数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans = ans*26 + (s.charAt(i) - 'A'+1);
        }
        System.out.println(ans);
        //LANQIAO
        //3725573269
    }
}
