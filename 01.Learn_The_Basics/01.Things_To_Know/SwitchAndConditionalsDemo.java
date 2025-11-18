// What this file covers:
// - When to use if-else vs switch
// - switch with int, char, String, enum (explain)
// - break, fall-through behavior, default case
// - constant expressions requirement
// - nested switch (demo + caution)
// - best practices and common pitfalls

import java.util.Scanner;

public class SwitchAndConditionalsDemo {

    // A small enum example to show how switch works with enums
    enum DayPart {
        MORNING, AFTERNOON, EVENING, NIGHT
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== If-Else vs Switch — Quick Decision Guide ===");
        System.out.println("Use if-else when:");
        System.out.println("  - Conditions are complex (ranges, boolean logic)");
        System.out.println("  - Conditions are not simple equality checks");
        System.out.println("Use switch when:");
        System.out.println("  - You compare one expression against many constants");
        System.out.println("  - You want cleaner code for many exact-match branches\n");

        /*
         * -----------------------------------------------------------
         * 1) Basic switch with integer (day-of-week example)
         * -----------------------------------------------------------
         */
        System.out.println("1) switch with int (day-of-week):");
        System.out.print("Enter a number (1-7) for day: ");
        int day = readIntSafe(sc);

        switch (day) {
            case 1:
                System.out.println("Monday");
                break; // break prevents fall-through
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
            default: // default runs when no case matches
                System.out.println("Invalid day number.");
        }
        System.out.println();

        /*
         * -----------------------------------------------------------
         * 2) Fall-through demonstration (multiple labels / grouped cases)
         * -----------------------------------------------------------
         */
        System.out.println("2) Fall-through & grouped cases:");
        System.out.print("Enter exam score (0-100): ");
        int score = readIntSafe(sc);

        // Grouped cases and fall-through are useful when multiple case-values map
        // to the same code. No 'break' between 90, 100 means they fall through to the
        // same block.
        switch (score / 10) { // integer division -> 0..10
            case 10: // 100 -> 10
            case 9:
                System.out.println("Grade A");
                break;
            case 8:
                System.out.println("Grade B");
                break;
            case 7:
                System.out.println("Grade C");
                break;
            case 6:
                System.out.println("Grade D");
                break;
            default:
                System.out.println("Grade F");
        }
        System.out.println();

        /*
         * -----------------------------------------------------------
         * 3) switch with char
         * -----------------------------------------------------------
         */
        System.out.println("3) switch with char (vowel/consonant check):");
        System.out.print("Enter a single letter: ");
        char ch = readCharSafe(sc);

        switch (Character.toLowerCase(ch)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(ch + " is a vowel.");
                break;
            default:
                System.out.println(ch + " is a consonant (or not a letter).");
        }
        System.out.println();

        /*
         * -----------------------------------------------------------
         * 4) switch with String (since Java 7)
         * -----------------------------------------------------------
         */
        System.out.println("4) switch with String (command example):");
        sc.nextLine(); // consume newline
        System.out.print("Enter command (start / stop / pause / resume): ");
        String cmd = sc.nextLine().trim().toLowerCase();

        switch (cmd) {
            case "start":
                System.out.println("Starting process...");
                break;
            case "stop":
                System.out.println("Stopping process...");
                break;
            case "pause":
                System.out.println("Pausing process...");
                break;
            case "resume":
                System.out.println("Resuming process...");
                break;
            default:
                System.out.println("Unknown command.");
        }
        System.out.println();

        /*
         * -----------------------------------------------------------
         * 5) switch with enums (best practice for enum branching)
         * -----------------------------------------------------------
         */
        System.out.println("5) switch with enum (DayPart example):");
        System.out.print("Enter time of day (morning/afternoon/evening/night): ");
        String tp = sc.nextLine().trim().toUpperCase();
        DayPart part;
        try {
            part = DayPart.valueOf(tp);
        } catch (IllegalArgumentException e) {
            part = null;
        }

        if (part == null) {
            System.out.println("Unknown time-of-day.");
        } else {
            switch (part) {
                case MORNING:
                    System.out.println("Good morning ☀️");
                    break;
                case AFTERNOON:
                    System.out.println("Good afternoon 🌤");
                    break;
                case EVENING:
                    System.out.println("Good evening 🌆");
                    break;
                case NIGHT:
                    System.out.println("Good night 🌙");
                    break;
            }
        }
        System.out.println();

        /*
         * -----------------------------------------------------------
         * 6) Constant expression requirement & compile-time checks
         * -----------------------------------------------------------
         * - Case labels must be compile-time constants (literals, final vars).
         * - Duplicate case labels cause compile-time error (commented example).
         */
        System.out.println("6) Constant expression notes:");
        System.out.println("Case labels must be constants (e.g., 1, 'A', \"foo\", final int).");
        System.out.println("Duplicate case values are not allowed (compile-time error).");
        System.out.println();

        /*
         * -----------------------------------------------------------
         * 7) Nested switch (possible but avoid deep nesting)
         * -----------------------------------------------------------
         * Demonstrate, but note readability concerns.
         */
        System.out.println("7) Nested switch (use sparingly):");
        System.out.print("Choose outer (1 or 2): ");
        int outer = readIntSafe(sc);

        switch (outer) {
            case 1:
                System.out.println("Outer case 1");
                System.out.print("  Enter inner choice (a/b): ");
                char inner = readCharSafe(sc);

                switch (inner) { // nested switch
                    case 'a':
                        System.out.println("  Inner a");
                        break;
                    case 'b':
                        System.out.println("  Inner b");
                        break;
                    default:
                        System.out.println("  Inner default");
                }
                break;
            case 2:
                System.out.println("Outer case 2");
                break;
            default:
                System.out.println("Outer default");
        }
        System.out.println("Note: nested switches reduce readability — prefer methods.\n");

        /*
         * -----------------------------------------------------------
         * 8) Fall-through trap demo (forgetting break)
         * -----------------------------------------------------------
         */
        System.out.println("8) Fall-through trap demo:");
        System.out.println("If we forget 'break', execution continues to following cases.");
        System.out.println("Example (score/10): input 85 -> case 8 -> will run only its case if break is present.");
        System.out.println("Be intentional about fall-through (sometimes used to group cases).");
        System.out.println();

        /*
         * -----------------------------------------------------------
         * 9) When to use if-else instead of switch (summary)
         * -----------------------------------------------------------
         */
        System.out.println("9) Use if-else when:");
        System.out.println(" - You need range checks (e.g., x > 10 && x < 20)");
        System.out.println(" - Conditions involve boolean logic or multiple variables");
        System.out.println(" - You rely on floating point comparisons or complex expressions\n");

        /*
         * -----------------------------------------------------------
         * 10) Quick cheat-sheet of dos and don'ts
         * -----------------------------------------------------------
         */
        System.out.println("=== Quick Switch Cheat-sheet ===");
        System.out.println(" - Allowed switch types: byte, short, char, int, enum, String (since Java 7).");
        System.out.println(" - Case labels must be compile-time constants (no non-final variables).");
        System.out.println(" - Use 'default' for unmatched cases.");
        System.out.println(" - 'break' prevents fall-through; omit intentionally to share code between cases.");
        System.out.println(" - Duplicate case values -> compile error.");
        System.out.println(" - Switch expressions (with arrows) exist in newer Java — topic for advanced study.");
        System.out.println();

        sc.close();
        System.out.println("=== End of Switch & Conditional Demo ===");
    }

    // Utility: safe int read — returns 0 if input invalid (and consumes token)
    private static int readIntSafe(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter an integer: ");
            sc.next(); // consume invalid token
        }
        return sc.nextInt();
    }

    // Utility: safe char read — reads first non-empty character of next token
    private static char readCharSafe(Scanner sc) {
        String token = sc.next();
        return token.length() > 0 ? token.charAt(0) : '\0';
    }
}
