package 第十届研究生_java;

import java.util.Scanner;

// 出现Ai +1
public class _08修改数组 {

    static int[] a = new int[100005];
    static int N = 100005;
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i < N; i++) {
            a[i] = i;
        }
        for (int i = 1; i <=n; i++) {
            int x = sc.nextInt();
            x = find(x);
            System.out.print(x+" ");
            a[x] = x + 1;
        }

    }

    private static int find(int x) {
        if (a[x] != x) a[x] = find(a[x]);
        return a[x];
    }
}
