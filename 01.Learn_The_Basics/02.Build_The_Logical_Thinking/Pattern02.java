/*
💡 Pattern Question:
--------------------
Write a program to print the following right-angled triangle pattern using stars (*).

Example:
Input: 5
Output:
* 
* * 
* * * 
* * * * 
* * * * * 

🧠 Approach to Solve:
---------------------
1. Take an integer input 'n' from the user (number of rows).
2. Use two nested loops:
   - Outer loop (i): runs from 0 to n-1 → handles the number of rows.
   - Inner loop (j): runs from 0 to i → prints '*' in increasing order for each row.
3. After printing each row, use println() to move to the next line.
4. Close the Scanner object after input is done.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create scanner object for input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 0; i < n; i++) { // Outer loop → for rows
            for (int j = 0; j <= i; j++) { // Inner loop → prints '*' i+1 times
                System.out.print("* "); // Print star with space
            }
            System.out.println(); // Move to next line after each row
        }

        sc.close(); // Close scanner to free resources
    }
}
