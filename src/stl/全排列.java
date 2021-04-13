package stl;

public class 全排列 {
    static int count =0;
    static void swap(char str[], int a, int b) {
        if (a == b) {
            return;
        }
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }
    static void printArr(char str[]) {
        for (char c : str) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    static void permutation(char str[], int t){

        if (t == str.length - 1 ){
            // 3. 停止的条件
            System.out.println(++count + " :");
            printArr(str);
            return;
        }

        for (int i = t; i < str.length; i++){
            swap(str, t, i);
            // 2.递归
            permutation(str , t + 1);
            swap(str, t, i);
        }


    }

    public static void main(String[] args) {
        char str[] = new String("ABC").toCharArray();
        permutation(str, 0);
    }
}
