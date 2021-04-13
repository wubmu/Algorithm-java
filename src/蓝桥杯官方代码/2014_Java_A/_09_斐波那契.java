/*
标题：斐波那契

    斐波那契数列大家都非常熟悉。它的定义是：

    f(x) = 1                    .... (x=1,2)
    f(x) = f(x-1) + f(x-2)      .... (x>2)

    对于给定的整数 n 和 m，我们希望求出：
    f(1) + f(2) + ... + f(n)  的值。但这个值可能非常大，所以我们把它对 f(m) 取模。
    公式参见【图1.png】

    但这个数字依然很大，所以需要再对 p 求模。

【数据格式】
输入为一行用空格分开的整数 n m p (0 < n, m, p < 10^18)
输出为1个整数

例如，如果输入：
2 3 5
程序应该输出：
0

再例如，输入：
15 11 29
程序应该输出：
25

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。


*/
//1.由定义fib(n) = fib(n+2)-fib(n+1)
//2.由1得Σf(n) = f(n+2)-1;

import java.math.BigInteger;
import java.util.Scanner;

//如果 m>=n+2那么f(m)>Σf(n)，结果是(f(n+2)-1)%p
//否则 结果为(f(n+2)-1)%f(m)%p==f(n+2)%f(m)%p-1
public class _09_斐波那契 {
  public static void main(String[] args) {
    // for (int i = 3; i <=10 ; i++) {
    //   System.out.println(fib(i).longValue());
    // }
    Scanner sc = new Scanner(System.in);
    long n, m, p;
    n = sc.nextLong();
    m = sc.nextLong();
    p = sc.nextLong();

    BigInteger bigP = BigInteger.valueOf(p);

    if (m >= n + 2) {
      BigInteger ans = fib(n + 2, bigP);
      System.out.println(ans.mod(bigP).longValue() - 1);
    } else {
      BigInteger fibm = fib(m);
      BigInteger ans = fib(n + 2, fibm);
      System.out.println(ans.mod(fibm).mod(bigP).longValue() - 1);
    }
  }
/*快速矩阵求fib*/
  private static BigInteger fib(long m) {

    BigInteger[][] ans = mPow(m - 2);
    return ans[0][0].add(ans[1][0]);
  }
  private static BigInteger fib(long m,BigInteger mod) {

    BigInteger[][] ans = mPow(m - 2,mod);
    return ans[0][0].add(ans[1][0]);
  }
  /*矩阵快速幂运算*/
  private static BigInteger[][] mPow(long n) {
    // a 1110
    BigInteger[][] a =
        {
            {
                BigInteger.ONE, BigInteger.ONE
            },
            {
                BigInteger.ONE, BigInteger.ZERO
            }
        };
    //单元矩阵
    BigInteger[][] ans =
        {
            {
                BigInteger.ONE, BigInteger.ZERO
            },
            {
                BigInteger.ZERO, BigInteger.ONE
            }
        };
    while (n != 0) {
      if ((n & 1) == 1) {
        //结果ans乘以当前平方
        BigInteger t1=ans[0][0];
        BigInteger t2=ans[1][0];
        ans[0][0] = ans[0][0].multiply(a[0][0]).add(ans[0][1].multiply(a[1][0]));
        ans[0][1] = t1.multiply(a[0][1]).add(ans[0][1].multiply(a[1][1]));
        ans[1][0] = ans[1][0].multiply(a[0][0]).add(ans[1][1].multiply(a[1][0]));
        ans[1][1] = t2.multiply(a[0][1]).add(ans[1][1].multiply(a[1][1]));
      }
      //对a进行平方
      BigInteger t1=a[0][0];
      BigInteger t2=a[1][0];
      BigInteger t3=a[0][1];
      a[0][0] = a[0][0].multiply(a[0][0]).add(a[0][1].multiply(a[1][0]));
      a[0][1] = t1.multiply(a[0][1]).add(a[0][1].multiply(a[1][1]));
      a[1][0] = a[1][0].multiply(t1).add(a[1][1].multiply(a[1][0]));
      a[1][1] = t2.multiply(t3).add(a[1][1].multiply(a[1][1]));
      n >>= 1;
    }
    return ans;
  }
  private static BigInteger[][] mPow(long n,BigInteger mod) {
    BigInteger[][] a =
        {
            {
                BigInteger.ONE, BigInteger.ONE
            },
            {
                BigInteger.ONE, BigInteger.ZERO
            }
        };
    //单元矩阵
    BigInteger[][] ans =
        {
            {
                BigInteger.ONE, BigInteger.ZERO
            },
            {
                BigInteger.ZERO, BigInteger.ONE
            }
        };
    while (n != 0) {
      if ((n & 1) == 1) {
        //结果乘以当前平方
        BigInteger t1=ans[0][0];
        BigInteger t2=ans[1][0];
        ans[0][0] = ans[0][0].multiply(a[0][0]).add(ans[0][1].multiply(a[1][0])).mod(mod);
        ans[0][1] = t1.multiply(a[0][1]).add(ans[0][1].multiply(a[1][1])).mod(mod);
        ans[1][0] = ans[1][0].multiply(a[0][0]).add(ans[1][1].multiply(a[1][0])).mod(mod);
        ans[1][1] = t2.multiply(a[0][1]).add(ans[1][1].multiply(a[1][1])).mod(mod);
      }
      //进行平方
      BigInteger t1=a[0][0];
      BigInteger t2=a[1][0];
      BigInteger t3=a[0][1];
      a[0][0] = a[0][0].multiply(a[0][0]).add(a[0][1].multiply(a[1][0])).mod(mod);
      a[0][1] = t1.multiply(a[0][1]).add(a[0][1].multiply(a[1][1])).mod(mod);
      a[1][0] = a[1][0].multiply(t1).add(a[1][1].multiply(a[1][0])).mod(mod);
      a[1][1] = t2.multiply(t3).add(a[1][1].multiply(a[1][1])).mod(mod);
      n >>= 1;
    }
    return ans;
  }
}
