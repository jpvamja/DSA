/*
💡 Pattern Question:
--------------------
Write a program to print the following pattern for a given integer n.

Example:
Input: 4
Output:
* * * *
* * * *
* * * *
* * * *

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user.
2. Use two nested loops:
   - Outer loop (i): runs from 0 to n-1 → for each row.
   - Inner loop (j): runs from 0 to n-1 → prints '* ' in each column.
3. After each row, print a newline using println().
4. Close the Scanner to avoid resource leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Taking input for number of rows/columns
        int n = sc.nextInt(); // Input size of pattern

        for (int i = 0; i < n; i++) { // Outer loop → number of rows
            for (int j = 0; j < n; j++) { // Inner loop → number of columns
                System.out.print("* "); // Print a star and space
            }
            System.out.println(); // Move to next line after one row is printed
        }

        sc.close(); // Closing scanner to prevent resource leak
    }
}
