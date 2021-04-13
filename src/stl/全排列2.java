package stl;

import java.util.Scanner;



// dfs+回溯
public class 全排列2 {
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
//        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr = {1,2,3,4,5};
        f(arr, 0);
    }
    //确定某一个排列的第k位
    private static void f(int[] arr, int k) {
        if (k==5) // 全部确定
        {
//            if (check(arr)) ans++;
            printArr(arr); // 打印下全排列的结果
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

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }


    }

