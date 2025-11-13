/*
💡 Pattern Question:
--------------------
Write a program to print the following number pattern for a given integer n.

Example:
Input: 5
Output:
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5 

🧠 Approach to Solve:
---------------------
1. Take an integer input 'n' from the user (number of rows).
2. Use two nested loops:
   - Outer loop (i): runs from 1 to n → controls the row number.
   - Inner loop (j): runs from 1 to i → prints numbers from 1 up to i for each row.
3. After printing all numbers in a row, print a newline using println().
4. Close the Scanner object after input is done.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create scanner for input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 1; i <= n; i++) { // Outer loop → controls number of rows
            for (int j = 1; j <= i; j++) { // Inner loop → prints 1 to i
                System.out.print(j + " "); // Print number followed by a space
            }
            System.out.println(); // Move to next line after one row
        }

        sc.close(); // Close scanner to release resources
    }
}
