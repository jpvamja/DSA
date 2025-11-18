// Given an integer N, return true it is an Armstrong number otherwise return false.
// An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
import java.util.Scanner;

public class Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int temp = number;
        int armstrong = 0;

        int digits = (int) (Math.log10(number) + 1);

        while (temp > 0) {
            int r = temp % 10;           
            armstrong += Math.pow(r, digits); 
            temp /= 10;                     
        }

        if (armstrong == number) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }

        sc.close();
    }
}
