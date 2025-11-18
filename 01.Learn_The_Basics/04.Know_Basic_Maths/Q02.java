
// Given an integer N return the reverse of the given number.
// Note: If a number has trailing zeros, then its reverse will not include them. For e.g., reverse of 10400 will be 401 instead of 00401.
import java.util.Scanner;

public class Q02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int reverse = 0;

        while (number > 0) {
            reverse = reverse * 10 + (number % 10);
            number /= 10;
        }

        System.out.println(reverse);
        sc.close();
    }
}