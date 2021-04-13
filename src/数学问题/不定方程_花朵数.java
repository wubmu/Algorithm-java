package 数学问题;

import java.math.BigInteger;

public class 不定方程_花朵数 {
    private static BigInteger calcu_21(int n ){
        BigInteger a = BigInteger.ONE;
        for (int i = 0; i < 21; i++) {
            a = a.multiply(BigInteger.valueOf(n));

        }
        return a;
    }
    public static void main(String[] args) {

    }
}
