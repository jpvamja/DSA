/*
💡 Pattern Question:
--------------------
Write a program to print the following inverted pyramid star pattern.

Example:
Input: 5
Output:
* * * * * * * * * 
  * * * * * * * 
    * * * * * 
      * * * 
        * 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use three nested loops:
   - 1st loop → Prints leading spaces before the stars to push them right.
   - 2nd loop → Prints stars ('*') in decreasing count each row.
   - 3rd loop → (Optional) Prints trailing spaces (for symmetry in console alignment).
3. The formula for stars per row = (2 * n - (2 * i + 1)).
4. After each row, move to the next line using println().
5. Close the Scanner after use to prevent memory leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create scanner for input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 0; i < n; i++) { // Outer loop → handles rows
            for (int j = 1; j <= i; j++) { // Print leading spaces
                System.out.print("  ");
            }
            for (int k = 1; k <= (2 * n - (2 * i + 1)); k++) { // Print stars
                System.out.print("* ");
            }
            for (int j = 1; j <= i; j++) { // Print trailing spaces (optional)
                System.out.print("  ");
            }
            System.out.println(); // Move to next line
        }

        sc.close(); // Close scanner to release resources
    }
}
