import java.util.Scanner;

/*
描述：正则问题

考虑一种简单的正则表达式：
只由 x ( ) | 组成的正则表达式。
小明想求出这个正则表达式能接受的最长字符串的长度。

例如 ((xx|xxx)x|(x|xx))xx 能接受的最长字符串是： xxxxxx，长度是6。

输入
----
一个由x()|组成的正则表达式。输入长度不超过100，保证合法。

输出
----
这个正则表达式能接受的最长字符串的长度。

例如，
输入：
((xx|xxx)x|(x|xx))xx

程序应该输出：
6

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。

*/
import static java.lang.Math.*;
public class _07正则问题 {

  static String s;
  static int len;
  static int pos;

  /*求出当前字符串，自当前下标到结束能匹配的字符串的长度*/
  static int f() {
    int m = 0;
    int tmp = 0;//用于保存连续的x的数量
    while (pos < len) {
      if (s.charAt(pos) == '(') {
        pos++;
        tmp += f();//等待后面的结果并累加到ans
      } else if (s.charAt(pos) == 'x') {//
        pos++;
        tmp++;
      } else if (s.charAt(pos) == '|') {
        pos++;
        m = max(m, tmp);
        tmp = 0;
      } else if (s.charAt(pos) == ')') {
        pos++;
        m = max(m, tmp);
        return m;
      }
    }
    m = max(m, tmp);
    return m;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    s=sc.nextLine();
    len = s.length();
    int ans = f();
    System.out.println(ans);
  }
}
