// DataTypesDemo.java
// Llama-style single-file Java quick reference for data types
// Author: Jeet Vamja
// Run: javac DataTypesDemo.java && java DataTypesDemo

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DataTypesDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Data Types — Llama Quick Reference ===\n");

        /* ---------------------------
         * PRIMITIVE TYPES (8 types)
         * --------------------------- */

        // 1) byte  : 8-bit signed integer
        byte bMin = Byte.MIN_VALUE; // -128
        byte bMax = Byte.MAX_VALUE; // 127
        System.out.println("byte range: " + bMin + " to " + bMax);
        byte b = 100; // literal fits in byte
        System.out.println("byte b = " + b);

        // 2) short : 16-bit signed integer
        short s = 20000;
        System.out.println("short s = " + s + " (range: " + Short.MIN_VALUE + " .. " + Short.MAX_VALUE + ")");

        // 3) int : 32-bit signed integer (default for integer literals)
        int i = 123_456_789; // underscores allowed for readability
        System.out.println("int i = " + i + " (default integer type)");

        // 4) long : 64-bit signed integer (use L suffix)
        long big = 3_000_000_000L; // must suffix with L if outside int range
        System.out.println("long big = " + big);

        // 5) float : 32-bit floating point (use f suffix)
        float f = 3.14f; // 'f' suffix required for float literal
        System.out.println("float f = " + f);

        // 6) double : 64-bit floating point (default for floating literals)
        double d = 2.718281828459045;
        System.out.println("double d = " + d + " (default floating type)");

        // 7) char : 16-bit Unicode character
        char c1 = 'A';
        char c2 = '\u03A9'; // Unicode Omega
        System.out.println("char c1 = " + c1 + ", char c2 (Omega) = " + c2);

        // 8) boolean : true / false only
        boolean flag = true;
        System.out.println("boolean flag = " + flag + "\n");

        /* ---------------------------
         * REFERENCE TYPES
         * --------------------------- */

        // String (immutable sequence of chars)
        String name = "Jeet";
        String greeting = "Hello, " + name + "!";
        System.out.println("String greeting: " + greeting);

        // Arrays (fixed-size)
        int[] arr = {1, 2, 3, 4};
        System.out.println("array arr: " + Arrays.toString(arr));
        // change element
        arr[1] = 20;
        System.out.println("after arr[1]=20 -> " + Arrays.toString(arr));

        // ArrayList (resizable list) - part of java.util
        ArrayList<String> list = new ArrayList<>();
        list.add("apple"); list.add("banana");
        System.out.println("ArrayList list: " + list);
        System.out.println();

        /* ---------------------------
         * CASTING (implicit and explicit)
         * --------------------------- */

        // Implicit casting (widening) - safe
        int small = 100;
        long widened = small; // int -> long implicit
        System.out.println("implicit cast int->long: " + widened);

        // Explicit casting (narrowing) - may lose data
        double bigDecimal = 123.987;
        int narrowed = (int) bigDecimal; // fractional part lost
        System.out.println("explicit cast double->int: " + bigDecimal + " -> " + narrowed);

        // Overflow example when casting large long to int
        long huge = 2_147_483_648L; // int max + 1
        int overflowed = (int) huge; // wrap-around occurs
        System.out.println("casting long 2_147_483_648L to int -> wrap-around: " + overflowed + "\n");

        /* ---------------------------
         * LITERALS & SUFFIXES
         * --------------------------- */
        int hex = 0xFF;    // hex literal
        int binary = 0b1010; // binary literal (since Java 7)
        long withL = 123L; // long literal
        float withF = 1.2f; // float literal
        System.out.println("hex 0xFF = " + hex + ", binary 0b1010 = " + binary);
        System.out.println();

        /* ---------------------------
         * WRAPPER CLASSES & PARSING
         * --------------------------- */
        String numStr = "2025";
        int parsed = Integer.parseInt(numStr); // String -> int
        Integer boxed = Integer.valueOf(parsed); // primitive -> wrapper (autoboxing)
        int unboxed = boxed; // auto-unboxing
        System.out.println("parseInt(\"2025\") -> " + parsed + ", boxed -> " + boxed + ", unboxed -> " + unboxed);

        String doubleStr = "3.14159";
        double parsedDouble = Double.parseDouble(doubleStr);
        System.out.println("parseDouble(\"3.14159\") -> " + parsedDouble + "\n");

        /* ---------------------------
         * NULL and EQUALITY for reference types
         * --------------------------- */
        String a = new String("hello");
        String bStr = "hello"; // string literal in pool
        System.out.println("a == bStr ? " + (a == bStr) + "  (reference equality)");
        System.out.println("a.equals(bStr) ? " + a.equals(bStr) + "  (value equality)");
        String maybe = null; // reference has no object
        System.out.println("maybe == null -> " + (maybe == null) + "\n");

        /* ---------------------------
         * DEFAULT VALUES (fields only - demo here as comments)
         * ---------------------------
         * Local variables must be initialized before use.
         * Class-level fields defaults (if not initialized):
         *  byte, short, int, long -> 0
         *  float, double -> 0.0
         *  char -> '\u0000'
         *  boolean -> false
         *  reference types -> null
         * --------------------------- */

        /* ---------------------------
         * USER INPUT & PARSING (Scanner)
         * --------------------------- */
        System.out.println("=== Scanner input demo (enter an int) ===");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        // Safe read: check if next token is int, otherwise parse from String
        if (sc.hasNextInt()) {
            int userInt = sc.nextInt();
            System.out.println("You entered (int): " + userInt);
        } else {
            String token = sc.next();
            try {
                int fromToken = Integer.parseInt(token);
                System.out.println("Parsed token to int: " + fromToken);
            } catch (NumberFormatException e) {
                System.out.println("Not an integer: " + token);
            }
        }
        sc.close();

        /* ---------------------------
         * FINAL QUICK TIPS
         * --------------------------- */
        System.out.println("\n=== Quick Tips ===");
        System.out.println("- Use int for most integer needs. Use long when > 2^31-1.");
        System.out.println("- Use double for decimal arithmetic (unless you need float for memory).");
        System.out.println("- Use char for single characters (Unicode).");
        System.out.println("- String is a reference type; use equals() to compare content.");
        System.out.println("- Watch out for overflow when casting or when values exceed ranges.");
        System.out.println("- Wrapper classes (Integer, Double...) are useful for collections and utilities.\n");

        System.out.println("=== End of demo ===");
    }
}
