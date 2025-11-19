// Given an integer N, write a program to print your name N times.

import java.util.Scanner;

public class Q01 {
    public void printName(String name, int n) {
        if (n == 0)
            return;
        System.out.println(name);
        printName(name, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int n = sc.nextInt();

        Q01 obj = new Q01();
        obj.printName(name, n);

        sc.close();
    }
}
