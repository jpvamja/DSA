/*
💡 Pattern Question:
--------------------
Write a program to print the following pattern for a given integer n.

Example:
Input: 5
Output:
1 
2 2 
3 3 3 
4 4 4 4 
5 5 5 5 5 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use two nested loops:
   - Outer loop (i): runs from 1 to n → represents the row number.
   - Inner loop (j): runs from 1 to i → prints the same number 'i' for that row.
3. Print a newline after each row using println().
4. Close the Scanner object after input is done to free system resources.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object for input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 1; i <= n; i++) { // Outer loop → for rows
            for (int j = 1; j <= i; j++) { // Inner loop → print 'i' i times
                System.out.print(i + " "); // Print the row number with space
            }
            System.out.println(); // Move to next line after each row
        }

        sc.close(); // Close scanner to release resources
    }
}
