// Given an integer N. Print the Fibonacci series up to the Nth term.

import java.util.Scanner;

public class Q08 {

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int last = fibonacci(n - 1);
        int slast = fibonacci(n - 2);
        return last + slast;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Q08 obj = new Q08();

        for (int i = 0; i <= n; i++) {
            System.out.print(obj.fibonacci(i) + " ");
        }
        sc.close();
    }
}
