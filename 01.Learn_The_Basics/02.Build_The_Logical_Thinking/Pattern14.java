/*
💡 Pattern Question:
--------------------
Write a program to print the following alphabet triangle pattern for a given integer n.

Example:
Input: 5
Output:
A 
A B 
A B C 
A B C D 
A B C D E 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use nested loops:
   - Outer loop (i): runs from 0 to n-1 → controls the row number.
   - Inner loop (j): runs from 'A' to ('A' + i) → prints alphabets incrementally.
3. After printing each row, use println() to move to the next line.
4. Close the Scanner after input is complete to avoid memory leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 0; i < n; i++) { // Outer loop → controls rows
            for (char j = 'A'; j <= 'A' + i; j++) { // Inner loop → prints alphabets from A to (A + i)
                System.out.print(j + " "); // Print character with a space
            }
            System.out.println(); // Move to next line after each row
        }

        sc.close(); // Close scanner
    }
}
