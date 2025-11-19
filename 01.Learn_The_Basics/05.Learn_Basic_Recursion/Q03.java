// Given an integer N, write a program to print numbers from N to 1.

import java.util.Scanner;

public class Q03 {
    public void printN(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printN(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Q03 obj = new Q03();
        obj.printN(n);

        sc.close();
    }
}
