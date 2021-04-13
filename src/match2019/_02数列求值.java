package match2019;
/*
    题目：数列求和
    【问题描述】
    给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求 第 20190324 项的最后 4 位数字。
    【思路】
    求和
        斐波那契数列的小变形
    求最后四位数字
        模10000

答案：4659
 */
public class _02数列求值 {
    public static void main(String[] args) {
        int a1 = 1, a2 = 1, a3 = 1,b=0;
        for (int i = 4; i <= 20190324 ; i++) {
            b = (a1 + a2 + a3) % 10000;

            a1 = a2 % 10000;
            a2 = a3 % 10000;
            a3 = b;

        }
        System.out.println(b);
    }
}
