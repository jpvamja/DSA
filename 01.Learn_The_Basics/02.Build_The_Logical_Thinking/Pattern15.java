/*
💡 Pattern Question:
--------------------
Write a program to print the following reverse alphabet triangle pattern for a given integer n.

Example:
Input: 5
Output:
A B C D E 
A B C D 
A B C 
A B 
A 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use nested loops:
   - Outer loop (i): runs from 0 to n-1 → controls the number of rows.
   - Inner loop (j): runs from 'A' to ('A' + (n - i - 1)) → prints decreasing alphabet sequences.
3. After printing all characters in a row, move to the next line using println().
4. Close the Scanner object after input to free system resources.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create Scanner object for user input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 0; i < n; i++) { // Outer loop → controls rows
            for (char j = 'A'; j <= 'A' + (n - i - 1); j++) { // Inner loop → prints decreasing alphabets
                System.out.print(j + " "); // Print character followed by a space
            }
            System.out.println(); // Move to next line
        }

        sc.close(); // Close scanner to release resources
    }
}
