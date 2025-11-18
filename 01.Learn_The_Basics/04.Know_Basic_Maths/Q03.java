// Given an integer N, return true if it is a palindrome else return false.
// A palindrome is a number that reads the same backward as forward. For example, 121, 1331, and 4554 are palindromes because they remain the same when their digits are reversed.
import java.util.Scanner;

public class Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        // int temp = number;
        // int reverse = 0;

        // while (number > 0) {
        //     reverse = reverse * 10 + (number%10);
        //     number /= 10;
        // }
        // if (temp == reverse) {
        //     System.out.println("Pallindrome Number.");
        // }
        // else{
        //     System.out.println("Not Pallindrome Number.");
        // }

        if (number < 0 || (number % 10 == 0 && number != 0)) {
            System.out.println("Not Pallindrome");
            sc.close();
            return;
        }

        int reversedHalf = 0;

        while (number > reversedHalf) {
            int digit = number % 10;
            reversedHalf = reversedHalf * 10 + digit;
            number = number / 10;
        }

        if (number == reversedHalf || number == reversedHalf / 10) {
            System.out.println("Pallindrome");
        } else {
            System.out.println("Not Pallindrome");
        }

        sc.close();
    }
}
