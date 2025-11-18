// This program demonstrates how to take input and display output in Java
// using both Scanner and BufferedReader classes, with clear explanations.

import java.util.*; // For Scanner
import java.io.*; // For BufferedReader and InputStreamReader

public class InputOutputDemo {
    public static void main(String[] args) throws IOException {

        /*
         * -------------------------------------------------------------
         * 1️⃣ BASIC OUTPUT using System.out.print() and println()
         * -------------------------------------------------------------
         * print() → prints text on the same line
         * println() → prints text and moves to the next line
         * -------------------------------------------------------------
         */

        System.out.println("=== OUTPUT EXAMPLES ===");
        System.out.print("Hello "); // stays on same line
        System.out.println("Jeet!"); // moves to next line after printing
        System.out.println("Welcome to Java Input/Output demo.");
        System.out.println();

        /*
         * -------------------------------------------------------------
         * 2️⃣ USER INPUT using Scanner Class
         * -------------------------------------------------------------
         * ➤ Scanner is the easiest way to take console input in Java.
         * ➤ You must import java.util.Scanner.
         * ➤ Methods:
         * nextInt() → reads integer
         * nextDouble() → reads double
         * next() → reads one word
         * nextLine() → reads a full line (string with spaces)
         * -------------------------------------------------------------
         */

        System.out.println("=== INPUT USING SCANNER ===");

        Scanner sc = new Scanner(System.in); // Create Scanner object

        System.out.print("Enter your name: ");
        String name = sc.nextLine(); // reads a full line of text

        System.out.print("Enter your age: ");
        int age = sc.nextInt(); // reads integer input

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble(); // reads decimal input

        // Output user input
        System.out.println("\n--- User Details ---");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Salary : " + salary);
        System.out.println();

        /*
         * -------------------------------------------------------------
         * 3️⃣ USER INPUT using BufferedReader (Faster I/O)
         * -------------------------------------------------------------
         * ➤ Used when performance matters (e.g., large data, competitive coding)
         * ➤ Reads input as String, so you must manually convert using:
         * Integer.parseInt(), Double.parseDouble(), etc.
         * ➤ Requires handling IOException (declared in main)
         * -------------------------------------------------------------
         */

        System.out.println("=== INPUT USING BUFFEREDREADER ===");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your city: ");
        String city = br.readLine(); // reads a full line (string)

        System.out.print("Enter your pin code: ");
        int pin = Integer.parseInt(br.readLine()); // convert string → int

        System.out.print("Enter your rating (decimal): ");
        double rating = Double.parseDouble(br.readLine()); // convert string → double

        // Output BufferedReader input
        System.out.println("\n--- Address Details ---");
        System.out.println("City   : " + city);
        System.out.println("Pin    : " + pin);
        System.out.println("Rating : " + rating);
        System.out.println();

        /*
         * -------------------------------------------------------------
         * 4️⃣ FORMATTED OUTPUT (Using printf)
         * -------------------------------------------------------------
         * ➤ printf() allows formatted printing (like C language)
         * ➤ Format Specifiers:
         * %d → integer
         * %f → float/double
         * %s → string
         * %.2f → round double to 2 decimal places
         * -------------------------------------------------------------
         */

        System.out.println("=== FORMATTED OUTPUT ===");
        System.out.printf("Hello %s, you are %d years old and earn ₹%.2f monthly.\n", name, age, salary);
        System.out.printf("You live in %s (Pin: %d) with rating %.1f\n", city, pin, rating);
        System.out.println();

        /*
         * -------------------------------------------------------------
         * 🧠 SUMMARY
         * -------------------------------------------------------------
         * OUTPUT:
         * - print() → prints without newline
         * - println() → prints with newline
         * - printf() → formatted output
         *
         * INPUT:
         * - Scanner → simple, slower, auto-parses data types
         * - BufferedReader → faster, needs manual type conversion
         *
         * Use Scanner for small projects or user input.
         * Use BufferedReader for large files or competitive programming.
         * -------------------------------------------------------------
         */

        sc.close();
        br.close();
    }
}
