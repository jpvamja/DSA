/*
💡 Pattern Question:
--------------------
Write a program to print the following number mirror pyramid pattern for a given integer n.

Example:
Input: 5
Output:
1                 1 
1 2             2 1 
1 2 3         3 2 1 
1 2 3 4     4 3 2 1 
1 2 3 4 5 5 4 3 2 1 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use three main parts per row:
   - Left ascending numbers → from 1 to i.
   - Middle spaces → start with 2*(n-1) spaces and decrease by 2 each row.
   - Right descending numbers → from i to 1.
3. For each row:
   - Print ascending numbers (1 to i).
   - Print spaces (based on the 'space' variable).
   - Print descending numbers (i to 1).
   - After completing each row, reduce the 'space' count by 2.
4. Print a newline after each row using println().
5. Close the Scanner to prevent memory leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for input
        int n = sc.nextInt(); // Input number of rows
        int space = 2 * (n - 1); // Initial space between left & right halves

        for (int i = 1; i <= n; i++) { // Outer loop → for each row
            // Print left ascending numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            // Print middle spaces
            for (int k = 1; k <= space; k++) {
                System.out.print("  ");
            }

            // Print right descending numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            System.out.println(); // Move to next line
            space -= 2; // Decrease space by 2 for next row
        }

        sc.close(); // Close scanner
    }
}
