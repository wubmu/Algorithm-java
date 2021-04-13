package match2017;
/*
标题：包子凑数

小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有N种蒸笼，其中第i种蒸笼恰好能放Ai个包子。每种蒸笼都有非常多笼，可以认为是无限笼。

每当有顾客想买X个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有X个包子。比如一共有3种蒸笼，分别能放3、4和5个包子。当顾客想买11个包子时，大叔就会选2笼3个的再加1笼5个的（也可能选出1笼3个的再加2笼4个的）。

当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有3种蒸笼，分别能放4、5和6个包子。而顾客想买7个包子时，大叔就凑不出来了。

小明想知道一共有多少种数目是包子大叔凑不出来的。

输入
----
第一行包含一个整数N。(1 <= N <= 100)
以下N行每行包含一个整数Ai。(1 <= Ai <= 100)

输出
----
一个整数代表答案。如果凑不出的数目有无限多个，输出INF。

例如，
输入：
2
4
5

程序应该输出：
6

再例如，
输入：
2
4
6

程序应该输出：
INF

样例解释：
对于样例1，凑不出的数目包括：1, 2, 3, 6, 7, 11。
对于样例2，所有奇数都凑不出来，所以有无限多个。

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
提交程序时，注意选择所期望的语言类型和编译器类型。


*/

import java.util.Scanner;

/**
 ax + by = c
 若a,b互质，则x，y一定有解且无穷
 st x,y>= 0  使 ax+by=c 无解的c的个数有限
 若a,b不互质，则可能无解（有解：c%gcd(a,b)=0）
            有解<===>有无限个多个c使方程无解

 a0x0 + a1x1 + a2x2 +.....anxn =C 有解 (a0,a1,...an)互质
 若不互质，有无限多个c导致方程无解

 有多少个c无解-------->完全背包问题
 */
public class _08包子凑数 {
/**
 * 1. 互质有限解
 * 2. 不互无限解
 */
static int[] a = new int[105]; //存放每笼包子数
static boolean[] dp = new boolean[105*105]; // 互质数的不能表示出来数的最大上界  (a-1)(b-1) -1
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, g = 1; // 笼子个数， 最大公约数
    n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
        a[i] = sc.nextInt();
        if (i == 1) g = a[i]; //初始化最大公约数
        else g = gcd(a[i], g);

        dp[a[i]] = true; // 初始化dp
    }
    if (g != 1) {
        System.out.println("INF");
    } else {

        /**
         * d[0] = true
         * if[d[0]]{
         *     d[0+a[i]] = true
         * }
         */
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] && j + a[i] < dp.length) {
                    dp[j + a[i]] = true;
//                    System.out.println(j+a[i]);
                }

            }
        }
        int ans = 0;
        //计算组合不出来的数
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) {
                ans++;
//                System.out.println(i);
            }
        }
        System.out.println(ans);

    }
}

    // 最大公约数
    static int gcd(int a, int b){
        if (b==0) return a;
        return gcd(b, a%b);
    }

}
