package 第十一届研究生_java;

import java.util.Arrays;

public class _七段码 {
    static int[] fa =  new int[8];
    static boolean[] vis = new boolean[8];
    static int count = 0;
    static int[][] e = new int[10][10];
    public static void main(String[] args) {
        e[1][2]=e[1][6]=1;
        e[2][1]=e[2][7]=e[2][3]=1;
        e[3][2]=e[3][4]=e[3][7]=1;
        e[4][3]=e[4][5]=1;
        e[5][4]=e[5][6]=e[5][7]=1;
        e[6][1]=e[6][5]=e[6][7]=1;
        dfs(1);
        System.out.println(count);
        System.out.println(Math.pow(2,7));
    }

    public static void dfs(int k){
        if (k>7){
//            System.out.println(Arrays.toString(arr));
            check();
            return;
        }
        // 亮和不亮两种
        vis[k] = true;
        dfs(k+1);
        vis[k] = false;
        dfs(k+1);


//        for (int j = k; j < 7; j++) {
//            swap(j,k);
//
//            // 移交下一层
//            dfs(k+1);
//
//            swap(j,k);
//        }
//        return 0;

    }

    private static void check() {

        for (int i = 1; i <=7; i++) {
            fa[i] = i;
        }
        for (int i = 1; i <=7 ; i++) {
            for (int j = 1; j <= 7 ; j++) {
                if (e[i][j] ==1 && vis[i] && vis[j]){
                    int fx = find(i);
                    int fy = find(j);
                    if (fx != fy)
                        fa[fx] = fy;
                }
            }
        }
        int k = 0;
        for (int i = 1; i <= 7; i++) {
            if (vis[i] && fa[i]== i) k++;

        }
        if (k==1) count++;
    }

    private static int find(int j) {
        if (fa[j] != j)
            return fa[j] = find(fa[j]);
        return fa[j];
    }


}
