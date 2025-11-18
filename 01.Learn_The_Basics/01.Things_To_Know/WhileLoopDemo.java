import java.util.Scanner;

public class WhileLoopDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * -------------------------------------------------------
         * 1️⃣ WHAT IS A WHILE LOOP?
         * -------------------------------------------------------
         * A 'while' loop executes a block of code repeatedly
         * as long as its condition evaluates to TRUE.
         *
         * Syntax:
         * while (condition) {
         * // body
         * }
         *
         * Steps:
         * 1. Evaluate condition.
         * 2. If true → execute loop body.
         * 3. After body → re-check condition.
         * 4. If false → exit loop.
         */

        System.out.println("=== 1️⃣ Basic While Loop Example ===");
        int count = 1;
        while (count <= 5) {
            System.out.println("Iteration " + count);
            count++; // increment for termination
        }
        System.out.println("Loop ended when count = " + count);
        System.out.println();

        /*
         * -------------------------------------------------------
         * 2️⃣ FACTORIAL EXAMPLE (Practical Use)
         * -------------------------------------------------------
         * Factorial of n = n * (n-1) * (n-2) * ... * 1
         * Using while loop to multiply and decrement each step.
         */
        System.out.println("=== 2️⃣ Factorial Using While Loop ===");
        System.out.print("Enter a number to find factorial: ");
        int n = sc.nextInt();
        int factorial = 1;
        int temp = n;
        while (temp > 0) {
            factorial *= temp;
            temp--; // decrement toward termination
        }
        System.out.println("Factorial of " + n + " is: " + factorial);
        System.out.println();

        /*
         * -------------------------------------------------------
         * 3️⃣ INPUT VALIDATION USING WHILE
         * -------------------------------------------------------
         * While loops are great for repeated user input
         * until valid data is entered.
         */
        System.out.println("=== 3️⃣ Input Validation Example ===");
        int age = -1;
        while (age < 0 || age > 120) {
            System.out.print("Enter a valid age (0–120): ");
            age = sc.nextInt();
            if (age < 0 || age > 120)
                System.out.println("Invalid age! Try again.");
        }
        System.out.println("Valid age entered: " + age);
        System.out.println();

        /*
         * -------------------------------------------------------
         * 4️⃣ INFINITE LOOPS & TERMINATION CONDITIONS
         * -------------------------------------------------------
         * Infinite loop example (⚠️ Don’t actually run endlessly!)
         * while (true) { ... } → runs forever unless break is used.
         * Example below runs safely with a break.
         */
        System.out.println("=== 4️⃣ Infinite Loop (with break) Example ===");
        int i = 1;
        while (true) {
            System.out.print(i + " ");
            if (i == 10)
                break; // stops infinite loop
            i++;
        }
        System.out.println("\nLoop stopped after break.\n");

        /*
         * -------------------------------------------------------
         * 5️⃣ USING break AND continue
         * -------------------------------------------------------
         * - break: exits loop immediately
         * - continue: skips to next iteration
         */
        System.out.println("=== 5️⃣ Break and Continue Example ===");
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 6;

        System.out.println("Searching for " + target + " using break:");
        int idx = 0;
        while (idx < numbers.length) {
            if (numbers[idx] == target) {
                System.out.println("Found target: " + target);
                break; // exit early
            }
            System.out.println("Checking: " + numbers[idx]);
            idx++;
        }

        System.out.println("\nPrinting only odd numbers using continue:");
        int j = 0;
        while (j < numbers.length) {
            j++;
            if (numbers[j - 1] % 2 == 0)
                continue; // skip evens
            System.out.println("Odd: " + numbers[j - 1]);
        }
        System.out.println();

        /*
         * -------------------------------------------------------
         * 6️⃣ DO-WHILE LOOP (Executes at least once)
         * -------------------------------------------------------
         * Syntax:
         * do {
         * // body
         * } while (condition);
         *
         * Difference:
         * - while → checks condition first
         * - do-while → executes once before checking
         */
        System.out.println("=== 6️⃣ Do-While Example (executes at least once) ===");
        int num;
        do {
            System.out.print("Enter a positive number: ");
            num = sc.nextInt();
        } while (num <= 0);
        System.out.println("You entered: " + num);
        System.out.println();

        /*
         * -------------------------------------------------------
         * 7️⃣ NESTED WHILE LOOPS
         * -------------------------------------------------------
         * Example: Print a multiplication table (2D pattern)
         */
        System.out.println("=== 7️⃣ Nested While Loop Example ===");
        int row = 1;
        while (row <= 3) {
            int col = 1;
            while (col <= 3) {
                System.out.print("(" + row + "," + col + ") ");
                col++;
            }
            System.out.println();
            row++;
        }
        System.out.println();

        /*
         * -------------------------------------------------------
         * 8️⃣ OPTIMIZATION & BEST PRACTICES
         * -------------------------------------------------------
         * ✅ Always ensure the condition will eventually be false.
         * ✅ Update loop variables properly (avoid infinite loops).
         * ✅ Use break to exit early when done.
         * ✅ Use continue to skip unnecessary iterations.
         * ✅ Avoid heavy logic inside while loops when possible.
         */
        System.out.println("=== 8️⃣ Optimization Tips ===");
        System.out.println("- Always ensure a clear termination condition.");
        System.out.println("- Use break to stop early when goal reached.");
        System.out.println("- Use continue to skip redundant iterations.");
        System.out.println("- Keep loops efficient (avoid unnecessary checks).");
        System.out.println();

        /*
         * -------------------------------------------------------
         * 9️⃣ COMPARISON: while vs for vs do-while
         * -------------------------------------------------------
         * for: known number of iterations
         * while: unknown number of iterations
         * do-while: executes at least once
         */
        System.out.println("=== 9️⃣ Loop Comparison ===");
        System.out.println("Use for → when you know how many times to loop.");
        System.out.println("Use while → when you loop until a condition changes.");
        System.out.println("Use do-while → when the body must run at least once.");

        System.out.println("\n=== End of While Loop Demo ===");
        sc.close();
    }
}
