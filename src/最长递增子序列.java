
/*
    【问题描述：】
    给定一个序列，求解其中长度最长的递增子序列，最长递增子序列表示必须递增但是可以位置不连续的序列。
    例如：{4 2 3 1 5 }的最长递增子序列为 2 3 5，长度为 3 。

    【算法思路】

    f(n)表示为前n个数的最长子序列的长度
    num[5] >  num[4], f(5) = f(4) + 1
    num[5] <= num[4], f(5) = f(4)

    dp[i] = max{1 + dp[i] for j < i if num[j] < num[i]}
    // 从前面找一个比当前位置小的，遍历使得dp[i] + 1最大得
 */

import java.util.Arrays;

public class 最长递增子序列 {
    /*
        时间复杂度：O（N^2）
        空间复杂度：O（N）
     */
    public static int solve1(int[] nums){
        int len = nums.length;
        if (len < 2) //边界处理
            return len;
        int[] dp = new int[len]; // 动态方程
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    /*
        【思想】
        考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，
        则我们需要让序列上升得尽可能慢，
        因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
        【方法】
        动态规划+二分法查找
        【算法流程】
        最后整个算法流程为：
            当前已求出得最长子序列得长度为len（初始为1），从前往后遍历数组nums，在遍历num[i]时
                如果num[i] > d[len],则直接加入到d数组得尾部，并且更新len = len +1
                否则，在d的数组中二分查找，找到第一个比num[i]小的数d[k],并且更新d[k+1] = nums[i]
     */
    public static int solve2(int[] nums){
        int n = nums.length, len = 1;
        if (n < 2 )
            return 1;
        int[] dp = new int[n + 1];

        dp[len] = nums[0];

        //1、从前往后遍历nums
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len])  // 大于：直接加入尾部
                dp[++len] = nums[i];
            else {                    // 小于：二分法查找插入
                int l = 1, r = len;
                while (l < r){
                    int mid = l + r >> 1; // 相当于÷2
                    if (dp[mid] < nums[i]) //搜素右半边
                        l = l + 1;
                    else
                        r = mid; // 搜索左半区
                }
                dp[l] = nums[i];
            }
        }

        return len;
    }
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums2 = {1,2,-10,-8,-7};
        System.out.println(solve1(nums2));
        System.out.println(solve2(nums2));
    }

}
