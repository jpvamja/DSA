/*
💡 Pattern Question:
--------------------
Write a program to print the following inverted number pattern for a given integer n.

Example:
Input: 5
Output:
1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use two nested loops:
   - Outer loop (i): runs from 1 to n → controls the number of rows.
   - Inner loop (j): runs from 1 to (n - i + 1) → prints numbers in decreasing count each row.
3. Print numbers from 1 up to (n - i + 1) in each row.
4. After each row, move to the next line using println().
5. Close the Scanner to free system resources.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object for user input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 1; i <= n; i++) { // Outer loop → handles rows
            for (int j = 1; j <= (n - i + 1); j++) { // Inner loop → prints numbers 1 to (n - i + 1)
                System.out.print(j + " "); // Print current number followed by a space
            }
            System.out.println(); // Move to next line after each row
        }

        sc.close(); // Close scanner to avoid resource leaks
    }
}
