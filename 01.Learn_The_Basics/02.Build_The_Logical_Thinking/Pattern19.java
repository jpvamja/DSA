/*
💡 Pattern Question:
--------------------
Write a program to print the following Butterfly Star Pattern for a given integer n.

Example:
Input: 5
Output:
* * * * * * * * * * 
* * * *     * * * * 
* * *         * * * 
* *             * * 
*                 * 
*                 * 
* *             * * 
* * *         * * * 
* * * *     * * * * 
* * * * * * * * * * 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' (the number of rows for each half of the butterfly).
2. The pattern consists of two halves:
   - 🔼 Upper Half → Stars decrease while inner spaces increase.
   - 🔽 Lower Half → Stars increase while inner spaces decrease.

3. For the Upper Half:
   - Outer loop (i): runs from 0 to n-1.
   - Print (n - i) stars on the left wing.
   - Print (2 * i) spaces in the middle.
   - Print (n - i) stars again on the right wing.

4. For the Lower Half:
   - Outer loop (i): runs from 1 to n.
   - Print i stars on the left wing.
   - Print (2 * n - 2 * i) spaces in the middle.
   - Print i stars on the right wing.

5. Print newline after each row.
6. Close the Scanner to free resources.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        int n = sc.nextInt(); // Input number of rows

        int initialSpace = 0;

        // 🔼 Upper Half
        for (int i = 0; i < n; i++) {

            // Left stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print("* ");
            }

            // Middle spaces
            for (int j = 0; j < initialSpace; j++) {
                System.out.print("  ");
            }

            // Right stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print("* ");
            }

            initialSpace += 2; // Increase space after each row
            System.out.println();
        }

        // Reset space for lower half
        initialSpace = 2 * n - 2;

        // 🔽 Lower Half
        for (int i = 1; i <= n; i++) {

            // Left stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // Middle spaces
            for (int j = 0; j < initialSpace; j++) {
                System.out.print("  ");
            }

            // Right stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            initialSpace -= 2; // Decrease space after each row
            System.out.println();
        }

        sc.close(); // Close scanner
    }
}
