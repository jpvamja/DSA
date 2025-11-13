/*
💡 Pattern Question:
--------------------
Write a program to print the following inverted right-angled triangle star pattern.

Example:
Input: 5
Output:
* * * * * 
* * * * 
* * * 
* * 
* 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Use two nested loops:
   - Outer loop (i): runs from 1 to n → represents the current row.
   - Inner loop (j): runs from 0 to (n - i) → prints decreasing stars per row.
3. After printing stars for a row, move to the next line using println().
4. Close the Scanner after input is done to avoid memory leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create scanner for input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 1; i <= n; i++) { // Outer loop → controls row count
            for (int j = 0; j < (n - i + 1); j++) { // Inner loop → print decreasing stars
                System.out.print("* "); // Print star and space
            }
            System.out.println(); // Move to next line after each row
        }

        sc.close(); // Close scanner to release resources
    }
}
