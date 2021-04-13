package stl;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
public class 大数 {

    @Test
    public void BigInterDemo(){
        BigInteger bi1 = new BigInteger("123456789");
        BigInteger bi2 = new BigInteger("987654321");

        System.out.println("加法操作： "+bi2.add(bi1));;

    }

    @Test
    public void jiecheng(){
        BigInteger f[] = new BigInteger[5500];
        f[0] = f[1] = BigInteger.ONE;
        for (int i = 2; i <= 10; ++i) {
            f[i] = f[i - 1].multiply(BigInteger.valueOf(i));
        }
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int m = cin.nextInt();
            System.out.println(f[m]);
        }

    }


    public static void main(String[] args) {
//        BigInteger f[] = new BigInteger[5500];
//        f[0] = f[1] = BigInteger.ONE;
//        for (int i = 2; i <= 5000; ++i) {
//            f[i] = f[i - 1].multiply(BigInteger.valueOf(i));
//        }
//        Scanner cin = new Scanner(System.in);
//        while (cin.hasNext()) {
//            int m = cin.nextInt();
//            System.out.println(f[m]);
//        }


//
//        System.out.println("===== demo permutation :");
//        for(List<String> list : Permutation.of(Arrays.asList("a", "b", "c")))
//            System.out.println(list);
    List<Integer> p = getPrimes(10000);
        for (int i :
             p) {
            System.out.println(i);
        }
    }

    // 判断单个自然数是不是素数
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {// 区别于常规方法的地方
            if (num % i == 0) return false;
        }
        return true;
    }

    // 求解素数集合
    public static List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) primes.add(i);
        }
        return primes;
    }

}
