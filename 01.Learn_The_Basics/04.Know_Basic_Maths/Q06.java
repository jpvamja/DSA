// Given an integer N, return all divisors of N.
// A divisor of an integer N is a positive integer that divides N without leaving a remainder. In other words, if N is divisible by another integer without any remainder, then that integer is considered a divisor of N.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        // for(int i = 1;i<= number;i++){
        // if (number%i == 0) {
        // System.out.print(i+" ");
        // }
        // }

        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisors.add(i);
                if ((number / i) != 1) {
                    divisors.add(number / i);
                }
            }
        }
        Collections.sort(divisors);

        for (int d : divisors) {
            System.out.print(d + " ");
        }
        sc.close();
    }
}
