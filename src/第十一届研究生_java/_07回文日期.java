package 第十一届研究生_java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class _07回文日期 {
    //回文判断
    //判断ABABBABA


    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String cur1 = sc.nextLine();
        Date current = sdf.parse(cur1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        boolean f1 = false, f2= false;
        while (true){
            cal.add(Calendar.DATE,1);
            String cur = sdf.format(cal.getTime());
            if (!f1){
                f1 = ishuiwen1(cur);
            }
            if (!f2){
                f2 = ishuiwen2(cur);
            }
            if (f1&&f2){
                break;
            }
        }

    }
    // 回文
    private static boolean ishuiwen1(String cur) {
        int l =0 , r =cur.length()-1;
        while (l<r){
            if (cur.charAt(l) != cur.charAt(r)) return false;
            l++;
            r--;
        }
        System.out.println(cur);
        return true;
    }
    // ABABA
    private static boolean ishuiwen2(String cur) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < cur.length(); i++) {
            set.add(cur.charAt(i));
        }
        if (set.size()!=2)
            return false;
        else {
            int l =0 , r =cur.length()-1;
            for (int i = 0; i < 3; i++) {
                if (cur.charAt(i)==cur.charAt(i+1)) return false;
            }

            return ishuiwen1(cur);
        }
    }
}
