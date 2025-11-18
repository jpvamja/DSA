// Given an integer N, return the number of digits in N.
import java.util.Scanner;

public class Q01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        // int digits = 0;
        // while (number>0) {
        // number /= 10;
        // digits++;
        // }

        
        number = Math.abs(number); 

        int digits;
        if (number == 0) {
            digits = 1;
        } else {
            digits = (int) (Math.log10(number) + 1);
        }

        System.out.println("Total digits: " + digits);
        sc.close();
    }
}
