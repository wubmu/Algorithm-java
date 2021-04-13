package match2019;

/*
    题目：平方和
    【问题描述】
    小明对数位中含有 2、0、1、9 的数字很感兴趣，在 1 到 40 中这样的数包 括 1、2、9、10 至 32、39 和 40，共 28 个，
他们的和是 574，平方和是 14362。 注意，平方和是指将每个数分别平方后求和。

    请问，在 1 到 2019 中，所有这样的数的平方和是多少?
    【思路】
    转换成string再判断，使用bigInteger 保证不溢出
 */
public class _01平方和 {
    public static boolean check(int i ){
        while ( i!=0 ){
            if (i%10==2||i%10==0||i%10==1||i%10==9)
                return true;
            i =i/10;
        }
        return false;
    }
    public static void main(String[] args) {
        long[] arr = new long[2020];
        long sum = 0;

        for (int i = 1; i <= 2019 ; i++) {
            //检查是否包含 2 0 1 9
            if (check(i)){
                sum += i*i;
            }
        }
        System.out.println(sum);
        //2658417853
    }
}
