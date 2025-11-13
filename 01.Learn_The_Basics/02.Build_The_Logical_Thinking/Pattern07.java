/*
💡 Pattern Question:
--------------------
Write a program to print the following pyramid star pattern.

Example:
Input: 5
Output:
          * 
        * * * 
      * * * * * 
    * * * * * * * 
  * * * * * * * * * 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use three nested loops:
   - 1st loop → Prints spaces before the stars to center-align the pyramid.
   - 2nd loop → Prints stars ('*') in odd count for each row using (2 * i + 1).
   - 3rd loop → (Optional) Prints trailing spaces for symmetry (not necessary for alignment but visually consistent here).
3. After each row, print a newline using println().
4. Close the Scanner to avoid resource leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 0; i < n; i++) { // Outer loop → handles each row
            for (int j = 1; j <= (n - i + 1); j++) { // Print leading spaces
                System.out.print("  ");
            }
            for (int k = 1; k <= (2 * i + 1); k++) { // Print stars in odd sequence
                System.out.print("* ");
            }
            for (int j = 1; j <= (n - i + 1); j++) { // Print trailing spaces (optional)
                System.out.print("  ");
            }
            System.out.println(); // Move to next line after one row
        }

        sc.close(); // Close scanner to free memory
    }
}
