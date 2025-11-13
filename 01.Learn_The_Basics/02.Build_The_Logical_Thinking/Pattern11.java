/*
💡 Pattern Question:
--------------------
Write a program to print the following binary (0-1) triangle pattern for a given integer n.

Example:
Input: 5
Output:
1 
0 1 
1 0 1 
0 1 0 1 
1 0 1 0 1 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. The pattern alternates between 1 and 0 in each row:
   - If the row number (i) is even → start with 1.
   - If the row number (i) is odd → start with 0.
3. For each row:
   - Use an inner loop to print numbers up to that row count.
   - After each print, toggle the number (1 → 0 or 0 → 1) using: start = 1 - start.
4. Move to the next line after each row using println().
5. Close the Scanner after input to prevent resource leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 0; i < n; i++) { // Outer loop → controls rows
            int start = 1; // Initialize starting number
            if (i % 2 == 0) { // For even rows → start with 1
                start = 1;
            } else { // For odd rows → start with 0
                start = 0;
            }

            for (int j = 0; j <= i; j++) { // Inner loop → print row values
                System.out.print(start + " ");
                start = 1 - start; // Toggle value between 0 and 1
            }

            System.out.println(); // Move to next line after each row
        }

        sc.close(); // Close scanner
    }
}
