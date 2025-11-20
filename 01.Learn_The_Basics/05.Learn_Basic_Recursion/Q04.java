
// Given a number ‘N’, find out the sum of the first N natural numbers.

import java.util.Scanner;

public class Q04 {

    // Parameterized way
    public void func(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        func(i - 1, sum + i);
    }

    // Functional way
    public int func2(int n) {
        if (n == 0) {
            return 0;
        }
        return n + func2(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Q04 obj = new Q04();

        System.out.print("Parameterized Sum: ");
        obj.func(n, 0);

        System.out.println("Functional Sum: " + obj.func2(n));

        sc.close();
    }
}