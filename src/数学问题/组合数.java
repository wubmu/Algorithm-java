package 数学问题;

/*
组合数 c[n][m] = c[n-1][m] + c[n-1][m-1]
 */
public class 组合数 {
    //首先预处理出所有阶乘取模的余数fact[N]，以及所有阶乘取模的逆元infact[N]
    //如果取模的数是质数，可以用费马小定理求逆元
    // x^n %mod

    /**O(n/2)
     * a^b mod c = (a^2)^(b/2) mod c    (b为偶数)
     * a^b mod c = ((a^2)^(b div 2)*a) mod c (b为奇数)
     */
    int qmi(int x, int n, int mod ){  //快速幂
        int res= 1;
        while (n > 0){
            if ((n & 1) ==1) // 判断奇偶 奇数 1
                res = res * x % mod;
            x >>= 1;        // x = x / 2;//x >> n 等同于 x / (2^n)
                            //x << n 等同于 x * (2^n)
            x = x * x % mod;

        }
        return res;
    }

    /**
     * 若p是质数，则对于任意整数 1 <= m <= n，有：
     * c(n,m) = c(n%p,m%p) *c(n/p, m / p)(mod p)
     */
    int C (int n ,int m , int k){// 求组合数C(n,m)
        if ( n < m) return 0;
        long x = 1, y =1; // x 是分子，y是分母
        for (int i = n, j = 1; j <= m ; i--,j++) {
            x = x*i % k;
            y = y*j % k;
        }

        return  1;
    }



}
