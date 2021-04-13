package dfs;

/*
    给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号+和-。
    对于数组中的任意一个整数，你都可以从+或-中选择一个符号添加在前面。

    返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
    【示例】
    输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

    1. 最少几步（BFS） 队列 能找到最短路径
    2. 几种(DFS) 堆栈
 */
public class _494目标和 {
    //枚举
    int count = 0;

    /**
     *
     * @param nums  数组
     * @param i     处理到第几个数
     * @param sum   目前总和
     * @param S     目标数
     * @return
     */
    public int solve1(int[] nums, int i , int sum, int S){
        if ( i == nums.length) {
            if (sum == S)
                count++;
        }else {
            solve1(nums, i+1, sum+nums[i], S);
            solve1(nums, i+1, sum-nums[i], S);
        }

        return count;
    }

    /**
     * 动态规划
     * dp[i][j] 表示用数组前i个元素，组成和为j的方案数。考虑第 i 个数num[i] 它可以被＋或者-
     * 状态转移方程如下：
     * dp[i][j] = dp[i-1][j + num[i]] + dp[i-1][j - num[i]]
     *转化成01背包
     * A正数的和，B负数的和
     * sum(A)- sum(B) = target
     * sum(A)         = target + sum(B)
     * sum(A) + sum(A)= target + sum(B) +sum(A)
     * 2 * sum(A)     = target + sum(nums)
     * @return
     */
    public int solve2(){
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        _494目标和 demo = new _494目标和();
        System.out.println(demo.solve1(nums,0,0,3));
    }
}
