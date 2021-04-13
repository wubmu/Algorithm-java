package match2013;

/*
标题: 梅森素数


    如果一个数字的 所有真因子之和等于自身，则称它为“完全数”或“完美数”

    例如：6 = 1 + 2 + 3

    28 = 1 + 2 + 4 + 7 + 14

    早在公元前300多年，欧几里得就给出了判定完全数的定理：

    若 2^n - 1 是素数，则 2^(n-1) * (2^n - 1) 是完全数。

    其中 ^ 表示“乘方”运算，乘方的优先级比四则运算高，例如：2^3 = 8， 2 * 2^3 = 16, 2^3-1 = 7

    但人们很快发现，当n很大时，判定一个大数是否为素数到今天也依然是个难题。

    因为法国数学家梅森的猜想，我们习惯上把形如：2^n - 1 的素数称为：梅森素数。

    截止2013年2月，一共只找到了48个梅森素数。 新近找到的梅森素数太大，以至于难于用一般的编程思路窥其全貌，所以我们把任务的难度降低一点：

    1963年，美国伊利诺伊大学为了纪念他们找到的第23个梅森素数 n=11213，在每个寄出的信封上都印上了“2^11213-1 是素数”的字样。

    2^11213 - 1 这个数字已经很大(有3000多位)，请你编程求出这个素数的十进制表示的最后100位。


答案是一个长度为100的数字串，请通过浏览器直接提交该数字。
注意：不要提交解答过程，或其它辅助说明类的内容。

 */


import java.math.BigInteger;

public class _03梅森素数 {

    public static void big(){
        BigInteger x = BigInteger.valueOf(2).pow(11213).subtract(BigInteger.ONE); // 2^11213 -1
        String s = x.toString();
        System.out.println(s.length());
        System.out.println(s.substring(s.length()-100));
        System.out.println(s.substring(s.length()-100).length());
    }
    public static void main(String[] args) {
        /*
            1. Api
         */
        big();
        // 快速幂
    }
}
