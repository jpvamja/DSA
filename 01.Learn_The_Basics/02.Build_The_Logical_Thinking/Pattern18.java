/*
💡 Pattern Question:
--------------------
Write a program to print the following reverse-starting alphabet triangle pattern.

Example:
Input: 5
Output:
E 
D E 
C D E 
B C D E 
A B C D E 

🧠 Approach to Solve:
---------------------
1. Take integer input 'n' from the user (number of rows).
2. Observe the pattern:
   - First row starts from 'E' (when n = 5) → only one character.
   - Next row starts from 'D' → prints till 'E'.
   - Third row starts from 'C' → prints till 'E'.
   - And so on...
3. Implementation logic:
   - Outer loop (i): runs from 0 to n-1 → controls rows.
   - Inner loop (j): starts from ('A' + n - 1 - i) → runs up to ('A' + n - 1).
   - Print each character followed by a space.
4. After each row, print a newline.
5. Close the Scanner to prevent resource leaks.

✅ Solved Code:
---------------
*/

import java.util.Scanner;

public class Pattern18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for input
        int n = sc.nextInt(); // Input number of rows

        for (int i = 0; i < n; i++) { // Outer loop → handles rows
            for (char j = (char) ('A' + n - 1 - i); j <= (char) ('A' + n - 1); j++) {
                System.out.print(j + " "); // Print characters from decreasing start to 'A' + n - 1
            }
            System.out.println(); // Move to next line
        }

        sc.close(); // Close scanner to free resources
    }
}
