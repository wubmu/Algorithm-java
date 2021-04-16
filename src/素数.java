import java.util.Arrays;

public class 素数 {
//素数的快速筛选（埃氏筛法）
    int countPrimes(int n ){
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim,true);

        for (int i = 2; i < n; i++) {
            // i的倍数不是素数
            for (int j = 2*i; j < n; j+=i) {
                isPrim[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }

    // 优化
    //素数的快速筛选（埃氏筛法）
    //比如 n = 25，i = 4 时算法会标记 4 × 2 = 8，4 × 3 = 12 等等数字，但是这两个数字已经被 i = 2 和 i = 3 的 2 × 4 和 3 × 4 标记了。
    // 让 j 从i的平方开始
    int countPrimes2(int n ){
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim,true);
        // 只用遍历 [2,sqrt[n]]
        for (int i = 2; i*i < n; i++) {
            // i的倍数不是素数
            for (int j = i*i; j < n; j+=i) {
                isPrim[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }
    public static void main(String[] args) {

    }
}
