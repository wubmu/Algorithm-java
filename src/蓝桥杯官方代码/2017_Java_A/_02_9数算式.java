import java.util.HashSet;
import java.util.Set;

/*
标题：9数算式

观察如下的算式：

9213 x 85674 = 789314562

左边的乘数和被乘数正好用到了1~9的所有数字，每个1次。
而乘积恰好也是用到了1~9的所有数字，并且每个1次。

请你借助计算机的强大计算能力，找出满足如上要求的9数算式一共有多少个？

注意：
1. 总数目包含题目给出的那个示例。
2. 乘数和被乘数交换后作为同一方案来看待。

请提交一个整数，不要填写任何多余内容或说明文字。
*/
public class _02_9数算式 {
  static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  static int ans;

  public static void main(String[] args) {
    f(0);
    System.out.println(ans/2);
  }

  private static void f(int k) {
    if (k == 9) {
      for (int i = 1; i <= 8; i++) {
        int x1 = a2i(0, i);
        int x2 = a2i(i, 9);
        int x = x1 * x2;
        if (check(x)) {
          ans++;
        }
      }
    }
    for (int i = k; i < 9; i++) {
      int t = a[k];
      a[k] = a[i];
      a[i] = t;
      f(k + 1);
      t = a[k];
      a[k] = a[i];
      a[i] = t;
    }
  }

  private static boolean check(int x) {
    String s = x + "";
    if (s.length() != 9||s.indexOf('0')>-1) return false;
    Set<Character> set = new HashSet<Character>();
    for (int i = 0; i < s.length(); i++) {
      set.add(s.charAt(i));
    }
    return set.size() == 9;
  }

  private static int a2i(int i, int j) {
    int ans = 0;
    int p = 1;
    for (int k = j - 1; k >= i; k--) {
      ans += a[k] * p;
      p *= 10;
    }
    return ans;
  }
}
