/*
    问题描述：
一个背包的总容量为V,现在有N类物品,第i类物品的重量为weight[i],价值为value[i]
那么往该背包里装东西,怎样装才能使得最终包内物品的总价值最大。这里装物品主要由三种装法：
1、0-1背包：每类物品最多只能装一次
2、多重背包：每类物品都有个数限制，第i类物品最多可以装num[i]次
3、完全背包：每类物品可以无限次装进包内

状态转移方程
    j <  w, dp[i][j] = dp[i-1][j] // 背包装不下该东西，最大价值不变
    j >= w, dp[i][j] = max{dp[i-1], dp[]}
 */

public class 背包问题 {
    /**
     *  递归法
     * @param w         物品的重量数组
     * @param v         物品的价值数组
     * @param index     当前待选的物品索引
     * @param capacity  当前背包的容量
     * @return          最大价值
     */
    private static int solveKS01(int[] w, int[] v, int index, int capacity){
        // 基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0)
            return 0;
        // 不放第index个物品所得的价值
        int res = solveKS01(w , v, index-1, capacity);
        // 放第index个物品的所得价值（前提：第index个物品可以放的下）
        if (w[index] <= capacity){
            res = Math.max(res, v[index] + solveKS01(w, v, index-1, capacity - w[index]));
        }
        return res;
    }
    // 动态规划
    private static int solveKS01_2(int[] w, int[] v,  int capacity){
        int size = w.length;
        if (size == 0){
            return 0;
        }

        int[][] dp = new int[size][capacity + 1];
        //初始化第一行,仅考虑容量为capacity的背包第0个物品的情况
        for (int i = 0; i <= capacity ; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0; // 二目运算
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= capacity ; j++) {
                int no_put = dp[i-1][j]; // 不放这个东西、
                if (w[i] <= j){ // 放这个东西
                    dp[i][j] = Math.max(no_put, v[i] + dp[i - 1][ j - w[i]]);
                }
            }
        }

        // 打印dp矩阵
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= capacity ; j++) {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }

        return dp[size - 1][capacity];
    }
    public static void main(String[] args) {
        int[] w = {2,1,3,2};
        int[] v = {12,10,20,15};
        System.out.println(solveKS01(w,v,w.length-1,5));
        System.out.println(solveKS01_2(w, v,5));
    }

}
