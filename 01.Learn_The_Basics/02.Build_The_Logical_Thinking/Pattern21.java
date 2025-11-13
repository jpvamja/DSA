/*
💡 Pattern Question:
--------------------
Write a program to print the following hollow square star pattern for a given integer n.

Example:
Input: 5
Output:
* * * * * 
*       * 
*       * 
*       * 
* * * * * 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (size of the square).
2. Use nested loops:
   - Outer loop (i): runs from 0 to n-1 → controls the number of rows.
   - Inner loop (j): runs from 0 to n-1 → controls the number of columns.
3. Print stars at the boundaries:
   - When `i == 0` (first row) OR `i == n - 1` (last row)
   - OR when `j == 0` (first column) OR `j == n - 1` (last column)
4. For all other cells (inside the square), print spaces.
5. Move to the next line after each row using `println()`.
6. Close the Scanner after reading input to free resources.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        int n = sc.nextInt(); // Input the size of the square

        for (int i = 0; i < n; i++) { // Outer loop → rows
            for (int j = 0; j < n; j++) { // Inner loop → columns
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* "); // Print star at boundaries
                } else {
                    System.out.print("  "); // Print space inside
                }
            }
            System.out.println(); // Move to next line after each row
        }

        sc.close(); // Close scanner
    }
}
