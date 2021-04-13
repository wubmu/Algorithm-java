package match2017;
/*
标题：方格分割

6x6的方格，沿着格子的边线剪开成两部分。
要求这两部分的形状完全相同。

如图：p1.png, p2.png, p3.png 就是可行的分割法。

试计算：
包括这3种分法在内，一共有多少种不同的分割方法。
注意：旋转对称的属于同一种分割法。

请提交该整数，不要填写任何多余的内容或说明文字。

*/

/**
 * 中心对称
 * 从中心点开始。dfs+标注
 * 509
 */
public class _04方格分割 {
    static int ans;
    static int[][] dir = {{-1,0 },{1,0},{0, 1},{0, -1}};
    static int[][] vis = new int[7][7];

    public static void main(String[] args) {
        dfs(3,3);
        System.out.println(ans/4);
    }

    private static void dfs(int x, int y) {
        if (x==0 || y==0 || x == 6 || y == 6){ //出口：剪刀边了
            ans++;
            return;
        }
        //设置当前访问点
        vis[x][y] = 1;
        //设置对称访问点
        vis[6-x][6-y] = 1;
        for (int i = 0; i < 4; i++) { //四个方向
            // 新的坐标
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || nx > 6|| ny < 0 || ny > 6)//越界
                continue;
            if (vis[nx][ny] == 0){
                dfs(nx,ny);
            }

        }

        //回溯
        vis[x][y] =0;
        vis[6-x][6-y] =0;
    }
}
