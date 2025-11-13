/*
💡 Pattern Question:
--------------------
Write a program to print a half-diamond star pattern for a given integer n.

Example:
Input: 5
Output:
* 
* * 
* * * 
* * * * 
* * * * * 
* * * * 
* * * 
* * 
* 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows for the top half).
2. The pattern has a total of (2 * n - 1) rows.
   - For rows 1 to n → number of stars increases.
   - For rows n+1 to 2n-1 → number of stars decreases.
3. Logic for stars:
   - stars = i when i ≤ n
   - stars = 2n - i when i > n
4. Use nested loops:
   - Outer loop → handles each row.
   - Inner loop → prints stars based on the 'stars' variable.
5. Print a newline after each row.
6. Close the Scanner object after input is read.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for input
        int n = sc.nextInt(); // Input number of rows (top half)

        for (int i = 0; i <= (2 * n - 1); i++) { // Outer loop → total 2n-1 rows
            int stars = i; // Number of stars in current row

            if (i > n) { // After middle row, stars start decreasing
                stars = 2 * n - i;
            }

            for (int j = 1; j <= stars; j++) { // Inner loop → print stars
                System.out.print("* ");
            }

            System.out.println(); // Move to next line
        }

        sc.close(); // Close scanner to free resources
    }
}
