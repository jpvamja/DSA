/*
💡 Pattern Question:
--------------------
Write a program to print the concentric number square (layered numbers) for a given integer n.

Example:
Input: 3
Output:
3 3 3 3 3 
3 2 2 2 3 
3 2 1 2 3 
3 2 2 2 3 
3 3 3 3 3 

🧠 Approach to Solve:
---------------------
1. The output is a (2*n - 1) x (2*n - 1) grid.
2. For each cell (i, j) compute the minimum distance to any border:
   minDist = min(i, j, 2*n-2 - i, 2*n-2 - j)
   value = n - minDist
3. Print value followed by a space for each cell, row by row.
4. Close the Scanner after printing the full grid.
*/

import java.util.Scanner;

public class Pattern22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = 2 * n - 1;

        for (int i = 0; i < size; i++) { // rows
            for (int j = 0; j < size; j++) { // columns
                int topDist = i;
                int leftDist = j;
                int bottomDist = (size - 1) - i;
                int rightDist = (size - 1) - j;

                int minDist = Math.min(Math.min(topDist, bottomDist),
                        Math.min(leftDist, rightDist));

                int value = n - minDist;
                System.out.print(value + " ");
            }
            System.out.println();
        }

        sc.close(); // close scanner after finishing all rows
    }
}
