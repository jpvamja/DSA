/*
💡 Pattern Question:
--------------------
Write a program to print the following alphabet pattern where each row contains 
the same character repeated multiple times.

Example:
Input: 5
Output:
A 
B B 
C C C 
D D D D 
E E E E E 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use two nested loops:
   - Outer loop (i): runs from 0 to n-1 → represents the current row.
   - Inner loop (j): runs from 0 to i → prints the same alphabet multiple times.
3. The character to print in row i is calculated as ('A' + i), which uses ASCII values.
   - Example: When i=0 → 'A', i=1 → 'B', i=2 → 'C', etc.
4. After printing all characters in a row, print a newline using println().
5. Close the Scanner object after reading input.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 0; i < n; i++) { // Outer loop → controls rows
            for (int j = 0; j <= i; j++) { // Inner loop → prints (i+1) characters
                System.out.print((char) ('A' + i) + " "); // Print same letter for current row
            }
            System.out.println(); // Move to next line after each row
        }

        sc.close(); // Close scanner to free resources
    }
}
