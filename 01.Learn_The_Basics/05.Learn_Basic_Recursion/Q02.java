// Given an integer N, write a program to print numbers from 1 to N.

import java.util.Scanner;

public class Q02 {
    public void printN(int n) {
        if (n == 0)
            return;
        printN(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Q02 obj = new Q02();
        obj.printN(n);

        sc.close();
    }
}
