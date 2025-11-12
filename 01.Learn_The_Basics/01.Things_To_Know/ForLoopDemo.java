// ForLoopDemo.java
// Llama-style single-file tutorial: For loops in Java (interactive + commented)
// Author: Jeet Vamja
// Run: javac ForLoopDemo.java && java ForLoopDemo

import java.util.ArrayList;
import java.util.Scanner;

public class ForLoopDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * -----------------------------
         * 1) Basic for-loop structure
         * -----------------------------
         * Syntax:
         * for (initialization; condition; update) {
         *     // body
         * }
         *
         * Execution order:
         *  - initialization (once)
         *  - check condition → if true run body, else exit
         *  - after body run update, then back to condition
         *
         * Typical use: run a block a fixed number of times.
         */
        System.out.println("1) Basic for-loop (prints 1..10):");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Iteration: " + i);
        }
        System.out.println();

        /*
         * -----------------------------
         * 2) Custom increment/decrement
         * -----------------------------
         * You can change the update expression (i += 5, i--, i *= 2, etc.)
         */
        System.out.println("2) Custom increments (i += 5):");
        for (int i = 1; i <= 21; i += 5) {
            System.out.println("i = " + i);
        }
        System.out.println();

        /*
         * -----------------------------
         * 3) Loop with conditional inside
         * -----------------------------
         * Use if/else inside loop to run different code per iteration
         */
        System.out.println("3) Conditional inside loop (print even/odd):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is even");
            } else {
                System.out.println(i + " is odd");
            }
        }
        System.out.println();

        /*
         * -----------------------------
         * 4) Nested for-loops
         * -----------------------------
         * Useful for 2-D structures (matrices) and pattern printing.
         * Time complexity multiplies: outer * inner iterations.
         */
        System.out.println("4) Nested loops (3x3 pairs):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i = " + i + ", j = " + j);
            }
        }
        System.out.println();

        /*
         * -----------------------------
         * 5) Pattern printing example
         * -----------------------------
         * Print a simple right-angled triangle of stars
         */
        System.out.println("5) Pattern printing (triangle):");
        int rows = 5;
        for (int r = 1; r <= rows; r++) {
            // inner loop prints r stars
            for (int c = 1; c <= r; c++) {
                System.out.print("*");
            }
            System.out.println(); // new line after each row
        }
        System.out.println();

        /*
         * -----------------------------
         * 6) Breaking out & continuing
         * -----------------------------
         * break -> exit loop immediately
         * continue -> skip remaining body and move to update/next iteration
         */
        System.out.println("6) break and continue demo:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("Reached 6 -> break (loop ends)");
                break; // loop stops entirely
            }
            if (i % 2 == 0) {
                System.out.println(i + " is even -> continue to next (skip print below)");
                continue; // skip to next iteration
            }
            System.out.println("Print only odd numbers or until break: " + i);
        }
        System.out.println();

        /*
         * -----------------------------
         * 7) Enhanced for-loop (for-each) for arrays & collections
         * -----------------------------
         * Syntax: for (Type item : collection) { ... }
         * Read-only traversal (can't change collection size).
         */
        System.out.println("7) Enhanced for (ArrayList example):");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple"); fruits.add("Banana"); fruits.add("Mango");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println();

        /*
         * -----------------------------
         * 8) Looping backwards (reverse)
         * -----------------------------
         * Useful when removing items from a list by index or iterating in reverse.
         */
        System.out.println("8) Looping backwards:");
        int[] a = {10, 20, 30, 40, 50};
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
        System.out.println();

        /*
         * -----------------------------
         * 9) Nested loops complexity warning
         * -----------------------------
         * If outer runs N and inner runs M, total is O(N*M).
         * Avoid deep nested loops if N is large (may be too slow).
         */

        /*
         * -----------------------------
         * 10) Practical examples - sum, factorial, array traversal
         * -----------------------------
         */
        System.out.println("10) Practical examples:");

        // Sum 1..N
        System.out.print("Enter a positive integer N to compute sum 1..N: ");
        int N = sc.nextInt();
        long sum = 0;
        for (int i = 1; i <= N; i++) sum += i;
        System.out.println("Sum 1.."+N+" = " + sum);

        // Factorial (watch for overflow; use long for larger values)
        System.out.print("Enter n (<=20) to compute n! (use <=20 to stay in long): ");
        int nf = sc.nextInt();
        long fact = 1;
        for (int i = 2; i <= nf; i++) fact *= i;
        System.out.println(nf + "! = " + fact);

        // Traversing an array
        int[] arr = {5, 3, 8, 1, 2};
        System.out.print("Array elements: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("\n");

        // Find max in array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("Max in array = " + max);
        System.out.println();

        /*
         * -----------------------------
         * 11) Nested for loops - 2D array traversal
         * -----------------------------
         */
        System.out.println("11) 2D array traversal (matrix):");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        /*
         * -----------------------------
         * 12) Common patterns interviewers ask
         * -----------------------------
         * - Two-pointer patterns using for loops
         * - Sliding window implemented with for and updating boundaries
         * - Loop invariant thinking: ensure correctness each iteration
         */

        /*
         * -----------------------------
         * 13) Tips & pitfalls
         * -----------------------------
         * - Off-by-one errors are common: watch <= vs < and start index (0 vs 1)
         * - Avoid modifying loop variable inside body unless intended
         * - Use descriptive variable names for nested loops (i,j,k or row,col)
         * - For large loops, consider time complexity and break early if possible
         */

        System.out.println("=== End of For Loop demo ===");
        sc.close();
    }
}
