package match2019;

import java.math.BigInteger;

public class _01平方和_大数 {
    public static boolean check(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='2' || chars[i]=='0'|| chars[i]=='1'|| chars[i]=='9'){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        BigInteger res = new BigInteger("0");
        for (int i = 1 ; i <= 2019; i++){
            String s = String.valueOf(i);
            if (check(s)){
                BigInteger temp = new BigInteger(s);
                res = res.add(temp.multiply(temp));
            }
        }

        System.out.println(res);
    }
}
