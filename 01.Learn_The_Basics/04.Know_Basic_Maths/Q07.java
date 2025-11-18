// Given an integer N, check whether it is prime or not. A prime number is a number that is only divisible by 1 and itself and the total number of divisors is 2.
import java.util.Scanner;

public class Q07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        // int count = 0;
        // for (int i = 1; i <= Number; i++) {
        // if (number % i == 0) {
        // count++;
        // }
        // }
        // if (count == 2) {
        // System.out.println("Prime");
        // } else {
        // System.out.println("Not Prime");
        // }

        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? "Prime" : "Not Prime");

        sc.close();
    }
}
