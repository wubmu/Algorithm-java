package match2013;

/*
B组第9题

标题：带分数

    100 可以表示为带分数的形式：100 = 3 + 69258 / 714

    还可以表示为：100 = 82 + 3546 / 197

    注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。

    类似这样的带分数，100 有 11 种表示法。

题目要求：
从标准输入读入一个正整数N (N<1000*1000)
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
注意：不要求输出每个表示，只统计有多少表示法！


例如：
用户输入：
100
程序输出：
11

再例如：
用户输入：
105
程序输出：
6


资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 3000ms

 */

import java.util.Scanner;

/**
 * 递归框架写全排列
 * 1-9全排列
 * 1-9分别一次
 * 求带分数表示种树
 * 分数整除，分母大于分子
 */
public class _08带分题 {
    static int ans;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N  = sc.nextInt();
        int[] arr = {1,2,3,4,5,6,7,8,9};
//        int[] arr = {1,2,3,4,5};
        f(arr, 0);
        System.out.println(ans);
    }
    //确定某一个排列的第k位
    private static void f(int[] arr, int k) {
        if (k==9) // 全部确定
        {
            check(arr) ;
            return;
//            printArr(arr); // 打印下全排列的结果
        }
        // 选定第k位，
        for (int i = k; i < arr.length; i++) {
            //将第i位和第k位交换
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            // 移交下一层，确定k+1位
            f(arr, k+1);

            //回溯（换回来）
            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }
    }
    //枚举加号和除号的位置
    private static boolean check(int[] arr) {
//        100 = 3 + 69258 / 714
        //加号前面最多是7个字符
        for (int i = 1; i <= 7 ; i++) {
            //如果此时加号之前的数额已经超过N ,没必要验算了
            int num1 = toInt(arr,0 , i) ; // 加号前面的数字
            if (num1 > N)continue;
            // 除号在最后一位之前
            for (int j = 1; j <= 9 - i -1; j++) {
                int num2 = toInt(arr, i, j); //起点 和个数  分母
                int num3 = toInt(arr, i+j, 9- i-j);
                if (num2%num3 == 0&& num1+num2/num3==N)
                    ans++;
            }
        }
        return true;
    }

    private static int toInt(int[] arr, int pos, int len) {
        int t= 1;
        int ans = 0;
        for (int i = pos+len-1; i >=pos ; i--) {
            ans += arr[i]*t;
            t*=10;
        }
        return ans;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
