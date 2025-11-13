/*
💡 Pattern Question:
--------------------
Write a program to print a diamond-shaped star pattern for a given integer n.

Example:
Input: 5
Output:
    *    
   ***   
  *****  
 ******* 
*********
*********
 ******* 
  *****  
   ***   
    *    

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows for the upper half).
2. The diamond is made of two parts:
   🔹 Upper Pyramid (increasing stars)
   🔹 Lower Inverted Pyramid (decreasing stars)

➡ For the Upper Pyramid:
   - Use outer loop (i = 0 → n-1) for rows.
   - Print (n - i - 1) spaces before stars.
   - Print (2 * i + 1) stars.
   - Print (n - i - 1) trailing spaces (optional for symmetry).

➡ For the Lower Pyramid:
   - Use outer loop (i = 0 → n-1).
   - Print i spaces before stars.
   - Print (2 * n - (2 * i + 1)) stars.
   - Print i trailing spaces (optional).

3. Print a newline after every row.
4. Close the Scanner after taking input to avoid memory leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        int n = sc.nextInt(); // Input number of rows

        // 🔼 Upper Pyramid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) { // Print leading spaces
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) { // Print stars
                System.out.print("*");
            }
            for (int j = 0; j < n - i - 1; j++) { // Print trailing spaces (optional)
                System.out.print(" ");
            }
            System.out.println();
        }

        // 🔽 Lower Inverted Pyramid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { // Print leading spaces
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) { // Print stars
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) { // Print trailing spaces (optional)
                System.out.print(" ");
            }
            System.out.println();
        }

        sc.close(); // Close scanner
    }
}
