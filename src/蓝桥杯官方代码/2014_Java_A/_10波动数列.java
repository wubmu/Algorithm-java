import java.util.Scanner;

/*
标题：波动数列

    观察这个数列：
    1 3 0 2 -1 1 -2 ...

    这个数列中后一项总是比前一项增加2或者减少3。

    栋栋对这种数列很好奇，他想知道长度为 n 和为 s 而且后一项总是比前一项增加a或者减少b的整数数列可能有多少种呢？

【数据格式】
    输入的第一行包含四个整数 n s a b，含义如前面说述。
    输出一行，包含一个整数，表示满足条件的方案数。由于这个数很大，请输出方案数除以100000007的余数。

例如，输入：
4 10 2 3
程序应该输出：
2

【样例说明】
这两个数列分别是2 4 1 3和7 4 1 -2。

【数据规模与约定】
对于10%的数据，1<=n<=5，0<=s<=5，1<=a,b<=5；
对于30%的数据，1<=n<=30，0<=s<=30，1<=a,b<=30；
对于50%的数据，1<=n<=50，0<=s<=50，1<=a,b<=50；
对于70%的数据，1<=n<=100，0<=s<=500，1<=a, b<=50；
对于100%的数据，1<=n<=1000，-1,000,000,000<=s<=1,000,000,000，1<=a, b<=1,000,000。

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
*/
public class _10波动数列 {

  private static int n;
  private static long s;
  private static long a;
  private static long b;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    s = sc.nextLong();
    a = sc.nextLong();
    b = sc.nextLong();

    int t = n * (n - 1) / 2;

    int[] dp = new int[t + 1];
    dp[0] = 1;
    for (int i = 1; i <= n - 1; i++) {
      for (int j = i * (i + 1) / 2; j >= i; j--) {
        // dp[j] += dp[j - i];
        // if (dp[j] > 100000007) dp[j] %= 100000007;
        dp[j] = (dp[j] + dp[j - i]) % 100000007;
      }
    }
    long ans = 0;
    for (int i = 0; i <= t; i++) {
      if ((s - i * a + (t - i) * b) % n == 0)
        ans = (ans + dp[i]) % 100000007;
      // if (ans > 100000007) ans %= 100000007;
    }
    System.out.println(ans);
  }
}
