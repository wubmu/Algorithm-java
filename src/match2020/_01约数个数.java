package match2020;

import java.util.Scanner;

public class _01约数个数 {
    public static void main(String[] args) {
        int count = 0;
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        for (int i = 1; i <= num ; i++) {
            if ( num % i == 0) {
                count++;
//                System.out.println(i);
            }
        }

        System.out.println(count);

    }
}
