/*
标题：六角填数

    如图【1.png】所示六角形中，填入1~12的数字。

    使得每条直线上的数字之和都相同。

    图中，已经替你填好了3个数字，请你计算星号位置所代表的数字是多少？

请通过浏览器提交答案，不要填写多余的内容。*/
public class _06六角填数 {
  static int[] arr = {2, 4, 5, 6, 7, 9, 10, 11, 12};

  public static void main(String[] args) {
    f(0);
  }

  private static void f(int k) {
    if (k == 9) {
      check();
      return;
    }
    for (int i = k; i < 9; i++) {
      int t = arr[k];
      arr[k] = arr[i];
      arr[i] = t;
      f(k + 1);
      t = arr[k];
      arr[k] = arr[i];
      arr[i] = t;
    }
  }

  private static void check() {
    int r1 = 1 + arr[0] + arr[3] + arr[5];
    int r2 = 1 + arr[1] + arr[4] + arr[8];
    int r3 = 8 + arr[0] + arr[1] + arr[2];
    int r4 = 11 + arr[3] + arr[6];
    int r5 = 3 + arr[2] + arr[4] + arr[7];
    int r6 = arr[5] + arr[6] + arr[7] + arr[8];

    if (r1 == r2 && r2 == r3 && r3 == r4 && r4 == r5 && r5 == r6) {
      for (int i = 0; i < 9; ++i) {
        System.out.println(arr[i]+" ");
      }
      System.out.println();
    }
  }
}
