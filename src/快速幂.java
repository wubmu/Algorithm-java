public class 快速幂 {
    int mod1(int x, int n, int mod){
        int ans = 1;
        for (int i= 1; i <= n; i++){
            ans*=x;
        }
        return ans%mod;
    }
    /**
    * (a*b)%c = ((a%c)*b)%c
    */
    int mod2(int x, int n, int mod){
        x = x % mod;
        int ans = 1;
        for (int i = 1; i <= n ; i++) {
            ans = (ans * x) % mod;
        }

        return ans % mod;
    }

    /**O(n/2)
     * a^b mod c = (a^2)^(b/2) mod c    (b为偶数)
     * a^b mod c = ((a^2)^(b div 2)*a) mod c (b为奇数)
     */

    int mod3(int x, int n , int mod){
        int ans = 1;
        x = x % mod;
        if (n % 2 == 1)
            ans = (ans * x) % mod;
        int k = (x * x) % mod; // a^2;
        for (int i = 1; i <= n/2; i++) {
            ans = (ans * k) % mod;
        }
        ans = ans % mod;
        return ans;
    }

    /**
     * O(logn)
     * @param x
     * @param n
     * @param mod
     * @return
     */
    int mod5(int x, int n , int mod){
        int ans = 1;
        x = x % mod;
        while ( n > 0 ){
            if (n % 2 == 1)
                ans = (ans * x) % mod;
            n = n / 2;
            x = (x * x) % mod;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("123");
    }


}
