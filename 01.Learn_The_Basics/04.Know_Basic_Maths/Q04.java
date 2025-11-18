
// Given two integers N1 and N2, find their greatest common divisor.
// The Greatest Common Divisor of any two integers is the largest number that divides both integers.
import java.util.Scanner;

public class Q04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // int min = Math.min(a, b);
        // int gcd = 1;
        // for (int i = min; i >= 1; i--) {
        // if (a % i == 0 && b % i == 0) {
        // System.out.println(gcd);
        // break;
        // }
        // }

        // Euclidean Algorithm
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) {
            System.out.println(b);
        } else {
            System.out.println(a);
        }
        sc.close();
    }
}
