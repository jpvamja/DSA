/*
💡 Pattern Question:
--------------------
Write a program to print the following Floyd’s Triangle pattern for a given integer n.

Example:
Input: 5
Output:
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use a variable `count` initialized to 1 — it will print continuous numbers.
3. For each row:
   - Outer loop (i): runs from 0 to n-1 → handles rows.
   - Inner loop (j): runs from 0 to i → prints `count` and increments it.
4. Print a newline after completing each row.
5. Close the Scanner object to prevent memory leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        int n = sc.nextInt(); // Input number of rows
        int count = 1; // Initialize counter for numbers

        for (int i = 0; i < n; i++) { // Outer loop → controls rows
            for (int j = 0; j <= i; j++) { // Inner loop → print increasing numbers
                System.out.print(count + " "); // Print current number
                count++; // Increment after each print
            }
            System.out.println(); // Move to next line after a row
        }

        sc.close(); // Close scanner to release resources
    }
}
