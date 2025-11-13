/*
💡 Pattern Question:
--------------------
Write a program to print the following symmetric butterfly star pattern for a given integer n.

Example:
Input: 5
Output:
*                 * 
* *             * * 
* * *         * * * 
* * * *     * * * * 
* * * * * * * * * * 
* * * *     * * * * 
* * *         * * * 
* *             * * 
*                 * 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows for the upper half).
2. The pattern has (2 * n - 1) total rows.
   - The first n rows form the upper butterfly (expanding).
   - The next (n - 1) rows form the lower butterfly (contracting).

3. For each row:
   - Calculate number of stars:
     → stars = i  (for first half)
     → stars = 2 * n - i  (for second half)
   - Print stars on the left wing.
   - Print spaces in the middle (`initialSpace` variable).
   - Print stars again on the right wing.

4. Adjust `initialSpace`:
   - For first half → decrease by 2 each row.
   - For second half → increase by 2 each row.

5. Print newline after each row.
6. Close the Scanner after input to prevent resource leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        int n = sc.nextInt(); // Input number of rows

        int initialSpace = 2 * n - 2; // Initial middle space

        // Full butterfly pattern (upper + lower)
        for (int i = 1; i <= (2 * n - 1); i++) {
            int stars = i;

            // After reaching the middle row, stars start decreasing
            if (i > n) {
                stars = 2 * n - i;
            }

            // Left wing
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            // Middle space
            for (int j = 1; j <= initialSpace; j++) {
                System.out.print("  ");
            }

            // Right wing
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            System.out.println(); // Move to next line

            // Adjust middle space
            if (i < n) {
                initialSpace -= 2; // Decrease space until the middle
            } else {
                initialSpace += 2; // Increase space after the middle
            }
        }

        sc.close(); // Close scanner
    }
}
