package 第十一届研究生_java;
/*
    最多交换次数：(n-1)+(n-2)....1 = n(n-1)/2
    n= 14   14*13/2 = 91
    n= 15   15*14/2 = 105

 */

public class _04蛇形填空 {
    static int[][] a = new int[100][100];

    public static void main(String[] args) {
        int x ,y;
        int cnt =1;
        for (int i = 1; i <= 40; i++) {
            if (i % 2 == 1){
                for (x=i, y = 1;x>=1 && y<= i; x--,y++){
                    a[x][y] = cnt++;
                }
            }else {
                for (x = 1 , y = i; x<=i && y>=1 ; x++,y--) {
                    a[x][y] = cnt++;
                }
            }
        }


        for (int i = 1; i <=20 ; i++) {
            for (int j = 1; j <=20 ; j++) {
                System.out.printf(a[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println(a[20][20]);
    }
}
