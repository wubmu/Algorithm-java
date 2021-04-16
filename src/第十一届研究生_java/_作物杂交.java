package 第十一届研究生_java;
/*
6 2 4 6
5 3 4 6 4 9
1 2
1 2 3
1 3 4
2 3 5
4 5 6
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _作物杂交 {
    static int N,M, K,T; //N物种个数，M初始物种数量，K杂交方案，目标种子
    static int[] time;
    static boolean[] ha;
    static Map<Integer,int[]> map = new HashMap<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N  = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        T = sc.nextInt();

        time = new int[N];
        ha = new boolean[N];
        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            ha[a-1] = true;
        }
        for (int i = 0; i < K; i++) {
            int a,b,c;
            a= sc.nextInt();
            b=sc.nextInt();
            c=sc.nextInt();
            map.put(c,new int[]{a,b});
        }

        int res = dfs(T);
        System.out.println(res);



    }

    private static int dfs(int t) {
        // 如果种子存在 返回0
        if (ha[t-1])
            return 0;
        //不存在的话
        ha[t-1] =true;
        int[] fa= map.get(t); // 得到两个父节点的编号
        //培育父节点的时间
        int a = dfs(fa[0]);
        int b = dfs(fa[1]);

        //培育时间
        int at= time[fa[0]-1];
        int bt= time[fa[1]-1];

        return Math.max(at,bt) + Math.max(a,b);
    }

}
