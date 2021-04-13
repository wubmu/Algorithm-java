package match2013;
/*
标题: 颠倒的价牌


        小李的店里专卖其它店中下架的样品电视机，可称为：样品电视专卖店。

        其标价都是4位数字（即千元不等）。

        小李为了标价清晰、方便，使用了预制的类似数码管的标价签，只要用颜色笔涂数字就可以了（参见p1.jpg）。

        这种价牌有个特点，对一些数字，倒过来看也是合理的数字。如：1 2 5 6 8 9 0 都可以。这样一来，如果牌子挂倒了，有可能完全变成了另一个价格，
        比如：1958 倒着挂就是：8561，差了几千元啊!!

        当然，多数情况不能倒读，比如，1110 就不能倒过来，因为0不能作为开始数字。

        有一天，悲剧终于发生了。某个店员不小心把店里的某两个价格牌给挂倒了。并且这两个价格牌的电视机都卖出去了!

        庆幸的是价格出入不大，其中一个价牌赔了2百多，另一个价牌却赚了8百多，综合起来，反而多赚了558元。

        请根据这些信息计算：赔钱的那个价牌正确的价格应该是多少？


        答案是一个4位的整数，请通过浏览器直接提交该数字。
        注意：不要提交解答过程，或其它辅助说明类的内容。

        * */
//4位数字
// 颠倒可读
// 一个价牌赔了2百多 一个价牌却赚了8百多 赚了558元
//问 赔钱的那个价牌正确的价格


import java.util.ArrayList;

public class _04颠倒的价牌 {

    public static void main(String[] args) {
        ArrayList<Price> a1 = new ArrayList<Price>();
        ArrayList<Price> a2 = new ArrayList<Price>();
        // 1.枚举四位数，简单筛选
        // 2.将其颠倒 和 原价做差，将赔200多的放在一个集合，将赚800多的放在一个集合
        // 3.遍历两个集合，检查是否相差558
        for (int i = 1000; i < 10000; i++) {
            // 2.将其颠倒 和 原价做差，将赔200多的放在一个集合，将赚800多的放在一个集合
            String s = "" + i;
            if (s.contains("3") || s.contains("4") || s.contains("7")) continue;
            String res = reverse(s);
            int i1 = Integer.parseInt(res);
            if (i1 < 1000) continue;   // 0不能开头
            int plus = i1 - i;
            if (plus > -300 && plus < -200)   // 快捷键 c a v 提取变量

                a1.add(new Price(i, plus));

            if (plus < 900 && plus > 800)   // 快捷键 c a v 提取变量
                a2.add(new Price(i, plus));
        }


        // 遍历两个集合，检查是否相加为558
        for (Price p1 : a1
        ) {
            for (Price p2 : a2
            ) {
                if (p1.plus + p2.plus == 558) {
                    System.out.println(p1.p + "  " + p1.plus);
                    System.out.println(p2.p + "  " + p2.plus);
                }
            }

        }


    }

    private static class Price {
        int p; // 原价
        int plus; //颠倒价 - 原价

        public Price(int p, int plus) {
            this.p = p;
            this.plus = plus;
        }
    }

    /*
     * 将数字字符进行翻转，
     *  1.每次遇到6时，翻转后将其变为9
     *  2.每次遇到9时，翻转后将其变为6
     * */
    private static String reverse(String s) {
        char[] ans = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '6') ans[i] = '9';
            else if (c == '9') ans[i] = '6';
            else ans[i] = c;
        }
            // 字符串翻转
        return new StringBuilder(new String(ans)).reverse().toString();
    }

    private static String reverse2(String s) {
        char[] ans = new char[s.length()];
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            char c = s.charAt(i);
            if (c == '6') ans[j] = '9';
            else if (c == '9') ans[j] = '6';
            else ans[j] = c;
        }
        // 字符串翻转
        return new String(ans);
    }
}
