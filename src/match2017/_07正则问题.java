package match2017;

import java.util.Scanner;

import static java.lang.Math.max;

public class _07正则问题 {
    static String s;
    static int pos;
    static int p;
    static int dfs (){
        int ans =0;
        int t = 0;
        while (pos<s.length()){
            if (s.charAt(pos) == '('){
                pos++;
                t += dfs();
            }
            else if (s.charAt(pos) == 'x'){
                pos++;
                t++;
            }
            else if (s.charAt(pos) == '|'){
                ans = max(ans, t);
                t = 0;
                pos++;
            }else {
                ans = max(ans , t);
//                p += ans;
                pos++;
                break;
            }

        }
        ans = max(t , ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        int ans = dfs();
        System.out.println(ans);
    }
}
