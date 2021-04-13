/*
搭积木

小明最近喜欢搭数字积木，
一共有10块积木，每个积木上有一个数字，0~9。

搭积木规则：
每个积木放到其它两个积木的上面，并且一定比下面的两个积木数字小。
最后搭成4层的金字塔形，必须用完所有的积木。

下面是两种合格的搭法：

   0
  1 2
 3 4 5
6 7 8 9

   0
  3 1
 7 5 2
9 8 6 4

请你计算这样的搭法一共有多少种？

请填表示总数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。



  */
public class _03搭积木 {
  static int []arr={0,1,2,3,4,5,6,7,8,9};
  private static int ans;

  public static void main(String[] args) {
    f(0);
    System.out.println(ans);
  }
  /*
    0
  1 2
 3 4 5
6 7 8 9*/
  private static void f(int k) {
    if (k == 10) {
      ans++;
    }
    for (int i = k; i < 10; i++) {
      swap(k, i);
      int t;
      if (k==1&&arr[1]<arr[0]||
          k==2&&arr[2]<arr[0]||
          k==3&&arr[3]<arr[1]||
          k==4&&(arr[4]<arr[1]||arr[4]<arr[2])||
          k==5&&arr[5]<arr[2]||
          k==6&&arr[6]<arr[3]||
          k==7&&(arr[7]<arr[3]||arr[7]<arr[4])||
          k==8&&(arr[8]<arr[4]||arr[8]<arr[5])||
          k==9&&arr[9]<arr[5]){
        swap(k, i);
        continue;
      }
      f(k + 1);
      swap(k, i);
    }
  }

  private static void swap(int k, int i) {
    int t = arr[i];
    arr[i] = arr[k];
    arr[k] = t;
  }
}
