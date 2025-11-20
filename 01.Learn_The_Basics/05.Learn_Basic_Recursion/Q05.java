// Given a number X,  print its factorial.

import java.util.Scanner;

public class Q05 {
    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Q05 obj = new Q05();
        System.out.println(obj.factorial(n));
    }
}
