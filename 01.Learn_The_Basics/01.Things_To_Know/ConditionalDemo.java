import java.util.Scanner;

public class ConditionalDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Java Conditionals — Interactive Demo ===\n");

        /*
         * ------------------------------------------------------------
         * 1) SIMPLE if
         * ------------------------------------------------------------
         * Execute a block only when condition is true.
         */
        System.out.println("1) Simple if example:");
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        if (n % 2 == 0) { // condition uses == for equality
            System.out.println(n + " is even.");
        }
        // no else: when condition is false, nothing happens
        System.out.println();

        /*
         * ------------------------------------------------------------
         * 2) if-else
         * ------------------------------------------------------------
         * Choose between two branches.
         */
        System.out.println("2) if-else example:");
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are not an adult.");
        }
        System.out.println();

        /*
         * ------------------------------------------------------------
         * 3) else-if ladder (multiple mutually exclusive conditions)
         * ------------------------------------------------------------
         * Demonstrates grading logic. First version uses explicit bounds
         * Then we will show the refactored (clean) version.
         */
        System.out.println("3) Grading (else-if ladder) — verbose version:");
        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();

        // verbose checks (works but repetitive)
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks entered.");
        } else if (marks < 25) {
            System.out.println("Grade: F");
        } else if (marks >= 25 && marks <= 44) {
            System.out.println("Grade: E");
        } else if (marks >= 45 && marks <= 49) {
            System.out.println("Grade: D");
        } else if (marks >= 50 && marks <= 59) {
            System.out.println("Grade: C");
        } else if (marks >= 60 && marks <= 69) {
            System.out.println("Grade: B");
        } else { // marks >= 70
            System.out.println("Grade: A");
        }
        System.out.println();

        /*
         * ------------------------------------------------------------
         * 4) Refactored else-if (preferred)
         * Remove lower bounds because previous conditions already failed.
         */
        System.out.println("4) Grading — refactored clean version:");
        char grade; // compute grade using only upper bounds
        if (marks < 0 || marks > 100) {
            grade = 'X'; // invalid
        } else if (marks < 25) {
            grade = 'F';
        } else if (marks <= 44) {
            grade = 'E';
        } else if (marks <= 49) {
            grade = 'D';
        } else if (marks <= 59) {
            grade = 'C';
        } else if (marks <= 69) {
            grade = 'B';
        } else {
            grade = 'A';
        }
        System.out.println("Grade: " + (grade == 'X' ? "Invalid" : grade));
        System.out.println();

        /*
         * ------------------------------------------------------------
         * 5) NESTED if
         * ------------------------------------------------------------
         * Use nested if when decisions depend on previous checks.
         */
        System.out.println("5) Nested if example:");
        System.out.print("Enter a positive integer to check (0 or negative to skip): ");
        int x = sc.nextInt();
        if (x > 0) { // outer condition
            if (x % 2 == 0) { // inner condition
                System.out.println(x + " is positive and even.");
            } else {
                System.out.println(x + " is positive and odd.");
            }
        } else {
            System.out.println("Skipped nested example because input is not positive.");
        }
        System.out.println();

        /*
         * ------------------------------------------------------------
         * 6) TERNARY OPERATOR (compact if-else)
         * ------------------------------------------------------------
         * syntax: condition ? valueIfTrue : valueIfFalse
         */
        System.out.println("6) Ternary operator example:");
        System.out.print("Enter a number to compare with 100: ");
        int y = sc.nextInt();
        String comparison = (y > 100) ? "greater than 100" : (y == 100 ? "equal to 100" : "less than 100");
        System.out.println("Result: " + comparison);
        System.out.println();

        /*
         * ------------------------------------------------------------
         * 7) LOGICAL OPERATORS (&&, ||, !)
         * ------------------------------------------------------------
         * Combine conditions using AND, OR, NOT.
         */
        System.out.println("7) Logical operators:");
        System.out.print("Enter an integer for combined checks: ");
        int z = sc.nextInt();
        if (z % 2 == 0 && z > 0) {
            System.out.println(z + " is positive and even (both true).");
        }
        if (z % 2 == 0 || z % 3 == 0) {
            System.out.println(z + " is divisible by 2 or 3 (at least one true).");
        }
        if (!(z > 0)) {
            System.out.println(z + " is NOT positive (negation example).");
        }
        System.out.println();

        /*
         * ------------------------------------------------------------
         * 8) switch-statement (integer and String examples)
         * ------------------------------------------------------------
         * switch is useful when comparing a single value against many constants.
         */
        System.out.println("8) switch examples:");
        System.out.print("Enter a weekday number (1-Mon .. 7-Sun): ");
        int day = sc.nextInt();
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day number.");
        }
        System.out.println();

        // switch with String (common for commands)
        sc.nextLine(); // consume newline
        System.out.print("Enter command (start / stop / pause): ");
        String cmd = sc.nextLine().trim().toLowerCase();
        switch (cmd) {
            case "start":
                System.out.println("Command: start → Starting...");
                break;
            case "stop":
                System.out.println("Command: stop → Stopping...");
                break;
            case "pause":
                System.out.println("Command: pause → Pausing...");
                break;
            default:
                System.out.println("Unknown command.");
        }
        System.out.println();

        /*
         * ------------------------------------------------------------
         * 9) COMMON PITFALLS & GOOD PRACTICES
         * ------------------------------------------------------------
         * - Use braces {} even for single-line blocks to avoid mistakes.
         * - For floating point comparison, don't use == directly (use epsilon).
         * - Order your else-if from most specific -> least specific when needed.
         * - Don't forget to handle invalid inputs (default branch).
         * - Avoid overlapping ranges (refactor by checking upper bounds).
         */

        System.out.println("9) Common pitfalls demonstration:");

        // Example: floating point comparison (bad)
        double a = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 == 0.3 ? " + (a == 0.3)); // likely false -> floating precision issues

        // Correct way: compare with epsilon
        double epsilon = 1e-9;
        System.out.println("|(0.1+0.2) - 0.3| < eps ? " + (Math.abs(a - 0.3) < epsilon));
        System.out.println();

        /*
         * ------------------------------------------------------------
         * 10) SUMMARY / QUICK CHEAT SHEET
         * ------------------------------------------------------------
         * - if(condition) { ... } else { ... } // basic
         * - if(...) else if(...) ... else // ladder
         * - nested if // when dependent checks
         * - condition ? valIfTrue : valIfFalse // ternary expression
         * - switch(value) { case X: ...; break; ... } // multi-branch constant checks
         *
         * Logical operators:
         * - && (AND), || (OR), ! (NOT)
         *
         * Best practices:
         * - Use braces {}, handle defaults, prefer refactored ranges in else-if
         * ladders,
         * avoid == for doubles, use switch for many constant comparisons.
         * ------------------------------------------------------------
         */

        System.out.println("=== End of Conditional Demo ===");

        sc.close();
    }
}
