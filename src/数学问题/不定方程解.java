package 数学问题;

import org.junit.Test;

// ax+by = c
// 4x - 5y=7 的解个数
public class 不定方程解 {

    public static int solve1(){
        int ans = 0;
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (4*x - 5 * y ==7)
                    ans++;
            }
        }
        return ans;
    }

    /**
     * ax = c - by
     * 1. 求出一个特解
     * c/a, b/a能整除
     */
    @Test
    public  void solve2(){
        int ans = 0;
        // ax + by = c  a= 4 b =-5  c = 7
        // 1. 求特解   x0 y0
        // 2. 求通解： x = x0 + bt , y = y0 - at            t ......... -2 -1 , 0 , 1, 2, 3//看题目要求
        for (int y = 0; y < 100; y++) {
            if ((7 -(-5*y)) % 4 ==0){
                System.out.println(y);
                System.out.println((7 -(-5*y))/4);
                break;
            }
        }
//        return ans;
    }

}
