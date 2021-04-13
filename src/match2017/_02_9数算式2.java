package match2017;

import java.util.HashSet;
import java.util.Set;

public class _02_9数算式2 {
    static int res = 0; //最终结果
    static String num = ""; //字符串
    static int flag[] = new int[10]; //1-9的标识符

    public static void main(String[] args) {
        dfs(0,num);
        System.out.println(res/2);
    }

    private static void dfs(int n, String num) {
        if (n == 9){ // 结束的条件
            split_num(num);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (flag[i] == 0){
                flag[i] = 1;
                dfs(n+1,num + i);
                flag[i] = 0;
            }
        }

    }

    private static void split_num(String num) {
        for (int i = 1; i < 9; i++) {
            String left = num.substring(0,i);
            String right = num.substring(i,9);
            int result = Integer.parseInt(left) * Integer.parseInt(right);
            if (check(result))
                res++;
        }
    }

    private static boolean check(int num) {
        String  result = num+"";
        if (result.length() != 9 || result.indexOf('0')>-1) // 排除0
            return false;
        // 查重
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < result.length(); i++) {
            set.add(result.charAt(i));
        }

        return set.size() == 9;
    }
}
