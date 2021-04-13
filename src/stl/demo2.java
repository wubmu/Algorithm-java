package stl;

import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 常用库函数 翻转 去重   随机打乱 sort lower_bound/upper_bound nth_element
 */
public class demo2 {
    // 翻转
    @Test
    public void test1(){
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collections.reverse(a);
        System.out.println(a);



        // 翻转String
        String s = "abcd";
        s = new StringBuilder(s).reverse().toString();
        System.out.println(s);

        // 翻转数组
        int[] b = {1, 2 ,3 ,4 ,5};

        for (int l = 0, r = b.length -1; l < r ; l++, r--) {
            int t= b[l];
            b[l] = b[r];
            b[r] = t;
        }
        System.out.println(Arrays.toString(b));
    }

    // 去重
    @Test
    public void test2(){

        // 数组去重
        int[] a = {1, 1, 2, 2, 3, 3, 4};
        int m = 0;
        for (int i = 0; i < a.length; i++) {
            if ( i == 0 || a[i] != a[i - 1])
                a[m++] = a[i];
        }

        for (int i = 0; i < m; i++) {
            System.out.println(a[i]);
        }


        System.out.println("ArrayList 去重----------------------------------------");

        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4));
        System.out.println("set---------------------");

        Set<Integer> s = new HashSet<Integer>(); // 无序
        for (int i = 0; i < a.length ; i++) {
            s.add(a[i]);
        }
        for (int i :
             s) {
            System.out.println(i);
        }
    }

    // 随机打乱
    @Test
    public void test3(){
        // 打乱数组 ： 先转换成 list 打乱 再转换回
        int[] a = {1, 2, 3, 4, 5};
        List<Integer> list =  Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.shuffle(list);

        a = list.stream().mapToInt(Integer :: valueOf).toArray();
        System.out.println(Arrays.toString(a));


        // 打乱 ArrayList
         ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1 ,2 , 3, 4 ,5));
         Collections.shuffle(b);
        System.out.println(b);
    }


    // 排序
    @Test
    public void test4(){

        // 对数组排序
        int[] a = {3 ,1 ,2 ,6, 4};
        Arrays.sort(a);
        System.out.println(a.toString());


        // 对ArrayList
        System.out.println("---------------ArrayList");
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(3, 1, 2, 6, 4));
        Collections.sort(t);
        System.out.println(t);

        // 自定义排序
        // 两种方式：（1） 传入比较函数； （2）继承comparable接口 重写compareTo 方法
        class Rec implements Comparable<Rec>{
            int x, y;

            public Rec(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return "Rec{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }

            @Override
            public int compareTo(Rec o) {
                return this.x - o.x; // this 在前升序

            }
        }



        ArrayList<Rec> r = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            r.add(new Rec(-i,i));
        }

        // 方式一
        Collections.sort(r, ((o1, o2) -> o1.x-o2.x));
        System.out.println(r);

        //方式2
        Collections.sort(r);
        System.out.println(r);
    }



//    lower_bound/upper_bound
    @Test
    public void test5(){

    }
// nth_element

//    @Test
//    public void test6(){
//        int[] a = {6 ,2 ,1, 4 , 3, 5};
//        int k = 2;
//        System.out.println(quick_sort(a, 0, a.length - 1, k));
//        for (int x : a)
//            System.out.println(x);
//
//
//    }
//
//    public int quick_sort(int[] q, int l , int r, int k){
//        if ( l == r)
//            return q[l];
//        int x= q[l], i = l -1 , j = r + 1;
//        while ( i < j){
//            // 左边开始
//            while (q[++i] < x);
//            while (q[--j] < x);
//
//            if ( i < j){
//                int t = q[i]; q[i] = q[j]; q[j] = t;
//            }
//        }
//
//        int sl = j - l + 1;
//        if (k <= sl) return quick_sort(q, l, j , k);
//
//        return quick_sort(q, j + 1, r, k - sl);
//    }


    @Test
    public void test14() {

        // java 中不存在nth_element，可以自己实现
        int[] a = {6, 2, 1, 4, 3, 5};
        int k = 2;  // a[1]已经被排到正确的位置上(递增序)，第二小的数
        System.out.println(quick_sort(a, 0, a.length - 1, k));  // 2
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }

    // 返回 q[l...r]中第k小的数据
    public int quick_sort(int[] q, int l, int r, int k) {

        if (l == r) return q[l];

        int x = q[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int t = q[i]; q[i] = q[j]; q[j] = t;
            }
        }

        int sl = j - l + 1;
        if (k <= sl) return quick_sort(q, l, j, k);
        return quick_sort(q, j + 1, r, k - sl);
    }


    int kthBiggest(int arr[], int l , int r, int k ){



        return 0;
    }

}
