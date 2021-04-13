package match2020;

import org.junit.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
对于一个字符串 S，我们定义 S 的分值 f(S) 为 S 中恰好出现一次的字符个数。

例如 f(“aba”)=1，f(“abc”)=3, f(“aaa”)=1。

现在给定一个字符串 S[0…n−1]（长度为 n），请你计算对于所有 S 的非空子串 S[i…j](0≤i≤j<n)， f(S[i…j]) 的和是多少。

输入格式
输入一行包含一个由小写字母组成的字符串 S。

输出格式
输出一个整数表示答案。

数据范围
对于 20% 的评测用例，1≤n≤10；
对于 40% 的评测用例，1≤n≤100；
对于 50% 的评测用例，1≤n≤1000；
对于 60% 的评测用例，1≤n≤10000；
对于所有评测用例，1≤n≤100000。

输入样例：
ababc
输出样例：
28
样例说明
所有子串 f 值如下：

a     1
ab    2
aba   2
abab  2
ababc 3
 b    1
 ba   2
 bab  2
 babc 3
  a   1
  ab  2
  abc 3
   b  1
   bc 2
    c 1
 */
public class 子串分解 {
    Scanner sc = new Scanner(System.in);
@Test
public void solve1(){
    int ans = 0 ;
    //暴力求解
    String line = "ababca";  // 43
    for (int l = 0; l < line.length(); l++) {
        Set<Character> set = new HashSet<>();
        for (int r = l; r < line.length(); r++) {
            set.add(line.charAt(r));
            ans += set.size();
        }
    }
    System.out.println(ans);

}
@Test
    public void solve2(){
    // ababc
    /* 对于字符串的每一个答案的贡献就等于   （它上一次出现的位置 - 现在的位置）*到字符串末尾的位置的
    a = 1*4 +1  5
    b = 2+4     8
    a = 2+3     6
    b = 2 * 2   4
    c = 1*(4+1) 5
                28
     */
    String line = "ababca"; // 43
    int[] num = new  int[26]; // 26个字母出现的位置
    long res = 0;
    long n = line.length();
    line = '0'+line; // 补充一位好计算
    for (int i = 1; i < line.length(); i++) {
        res += (i - num[line.charAt(i) - 'a']) *(n - i + 1);
        num[line.charAt(i) - 'a'] = i;
    }

    System.out.println(res);

}

}
