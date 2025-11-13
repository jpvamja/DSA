/*
💡 Pattern Question:
--------------------
Write a program to print the following centered alphabet palindromic pyramid pattern.

Example:
Input: 5
Output:
        A 
      A B A 
    A B C B A 
  A B C D C B A 
A B C D E D C B A 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. For each row:
   - Print leading spaces to center-align the pyramid.
   - Print alphabets in a palindromic sequence (A → middle → A).
3. Logic details:
   - Outer loop (i): controls rows (0 to n-1).
   - Print (n - i - 1) spaces at the start.
   - Use a variable `ch` starting from 'A' for each row.
   - Total characters in each row = (2 * i + 1).
   - The midpoint of the row (breakpoint) = (2 * i + 1) / 2.
   - Increment `ch` till the midpoint, then decrement to form the palindrome.
4. After each row, print newline.
5. Close the Scanner after input to prevent resource leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 0; i < n; i++) { // Outer loop → controls number of rows

            // Print leading spaces for alignment
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print("  ");
            }

            // Character printing logic
            char ch = 'A'; // Start with 'A' for each row
            int breakpoint = (2 * i + 1) / 2; // Midpoint where we switch from increment to decrement

            // Print characters in palindromic sequence
            for (int j = 1; j <= (2 * i + 1); j++) {
                System.out.print(ch + " ");
                if (j <= breakpoint) {
                    ch++; // Increment till midpoint
                } else {
                    ch--; // Decrement after midpoint
                }
            }

            // Print trailing spaces (optional, for symmetry)
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print("  ");
            }

            System.out.println(); // Move to next line after each row
        }

        sc.close(); // Close scanner
    }
}
