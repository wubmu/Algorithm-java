package 第十届研究生_java;

import java.math.BigInteger;
// 2019 4097482414389
public class _01立方和 {
    public static void main(String[] args) {
        long ans = 0;
        for (int i = 1; i <= 2019 ; i++) {
             if (check(i))
                 ans += Math.pow(i,3);
        }
        System.out.println(ans);
    }

    private static boolean check(int i) {
        String s = ""+i;
        return s.indexOf('2') >= 0 || s.indexOf('0') >= 0 || s.indexOf('1') >= 0 || s.indexOf('9') >= 0;
    }

}
