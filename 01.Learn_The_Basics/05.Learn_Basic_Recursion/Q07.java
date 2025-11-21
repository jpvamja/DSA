// "Given a string, check if the string is palindrome or not."  A string is said to be palindrome if the reverse of the string is the same as the string.

import java.util.Scanner;

public class Q07 {
    public boolean palindrome(String str, int i) {
        if (i >= str.length() / 2) {
            return true;
        }
        if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
            return false;
        }
        return palindrome(str, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Q07 obj = new Q07();
        System.out.println(obj.palindrome(str, 0));

        sc.close();
    }
}
