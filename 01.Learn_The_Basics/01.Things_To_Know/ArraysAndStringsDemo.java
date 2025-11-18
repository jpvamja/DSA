import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class ArraysAndStringsDemo {

    // ---------- Utility printing helpers ----------
    private static void printHeader(String title) {
        System.out.println("\n=== " + title + " ===");
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // ---------- Linear search (O(n)) ----------
    // Returns index of key or -1 if not found
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key)
                return i;
        return -1;
    }

    // ---------- Binary search (O(log n)) ----------
    // Requires sorted array. We use Java's Arrays.binarySearch for clarity.
    // Returns index >=0 if found, else (-(insertionPoint) - 1)
    // Example: Arrays.binarySearch(sortedArr, key)
    // Implement simple wrapper for demonstration:
    public static int binarySearchSorted(int[] sortedArr, int key) {
        return Arrays.binarySearch(sortedArr, key);
    }

    // ---------- Insert into fixed-size array (manual shifting) ----------
    // Inserts val at index pos by shifting elements right. If array full, returns
    // false.
    public static boolean arrayInsert(int[] arr, int size, int pos, int val) {
        // size = number of meaningful elements currently in arr (<= arr.length)
        if (size >= arr.length)
            return false; // no space
        if (pos < 0 || pos > size)
            return false; // invalid position
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1]; // shift right
        }
        arr[pos] = val;
        return true;
    }

    // ---------- Delete from fixed-size array (manual shifting) ----------
    // Deletes element at index pos and returns new size (size-1)
    public static int arrayDelete(int[] arr, int size, int pos) {
        if (pos < 0 || pos >= size)
            return size; // invalid -> no change
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1]; // shift left
        }
        arr[size - 1] = 0; // optional clear
        return size - 1;
    }

    // ---------- Demonstrate string utilities ----------
    // Shows various operations on strings
    public static void stringTutorial(String s) {
        printHeader("STRING BASICS (input = \"" + s + "\")");

        // length and char access
        System.out.println("Length: " + s.length());
        System.out.println("First char (charAt(0)): " + (s.length() > 0 ? s.charAt(0) : "N/A"));
        System.out.println("Substring (0, min(3,len)): " + s.substring(0, Math.min(3, s.length())));

        // concatenation
        String t = s + "_end"; // simple concatenation (creates new String)
        System.out.println("Concatenate with + => " + t);

        // StringBuilder (efficient for many concatenations)
        StringBuilder sb = new StringBuilder();
        sb.append(s).append("-A").append("-B");
        System.out.println("Using StringBuilder => " + sb.toString());

        // equals vs ==
        String a = new String(s); // new object
        String b = s; // reference to original literal (or same object)
        System.out.println("a == b ? " + (a == b) + "  (reference equality)");
        System.out.println("a.equals(b) ? " + a.equals(b) + "  (content equality)");

        // convert to char array and back
        char[] chars = s.toCharArray();
        System.out.println("Chars[]: " + Arrays.toString(chars));
        String fromChars = new String(chars);
        System.out.println("String from chars: " + fromChars);

        // split and join
        String csv = "one,two,three";
        System.out.println("Split example: " + Arrays.toString(csv.split(",")));

        // parse number safely
        String numStr = "123";
        try {
            int num = Integer.parseInt(numStr);
            System.out.println("Parsed int from \"" + numStr + "\": " + num);
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse: " + numStr);
        }

        // immutability demo
        String s2 = s.replace('a', 'x'); // produces new string
        System.out.println("After replace('a','x') => original: " + s + ", new: " + s2);
    }

    // ---------- Main interactive demo ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ARRAYS: creation, traversal, indexing
        printHeader("ARRAY BASICS");
        int[] arr = new int[8]; // fixed-size array of 8 ints (initialized to zeros)
        // Fill first 5 positions
        int size = 5;
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        System.out.println("Initial array (size=" + size + ", capacity=" + arr.length + "):");
        printArray(arr);

        // Random access O(1)
        System.out.print("Access index 2 -> ");
        System.out.println("arr[2] = " + arr[2]);

        // Linear search
        System.out.print("\nEnter a key to linear-search in array (e.g., 30): ");
        int key = sc.nextInt();
        int idx = linearSearch(Arrays.copyOf(arr, size), key); // search in meaningful part
        System.out.println(key + " found at index: " + idx);

        // Insert example (shift)
        System.out.print("\nInsert value 25 at index 2 (shifting) -> ");
        boolean ok = arrayInsert(arr, size, 2, 25);
        if (ok) {
            size++;
            printArray(Arrays.copyOf(arr, size));
        } else
            System.out.println("Insert failed (no space or invalid pos).");

        // Delete example
        System.out.print("\nDelete element at index 3 -> ");
        size = arrayDelete(arr, size, 3);
        printArray(Arrays.copyOf(arr, size));

        // Binary search requires sorted array
        printHeader("BINARY SEARCH (requires sorted array)");
        int[] sorted = Arrays.copyOfRange(arr, 0, size); // copy meaningful portion
        Arrays.sort(sorted);
        System.out.println("Sorted array: " + Arrays.toString(sorted));
        System.out.print("Enter key to binary-search: ");
        int key2 = sc.nextInt();
        int res = binarySearchSorted(sorted, key2);
        if (res >= 0)
            System.out.println(key2 + " found at index (in sorted array): " + res);
        else
            System.out.println(key2 + " not found (binarySearch returned " + res + ")");

        // ALTERNATIVE: dynamic array - ArrayList
        printHeader("ArrayList (dynamic array alternative)");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("ArrayList before add: " + list);
        list.add(1, 15); // insert at index
        list.remove(Integer.valueOf(20)); // remove by value
        System.out.println("ArrayList after modifications: " + list);

        // STRINGS: basics
        sc.nextLine(); // consume newline
        printHeader("STRINGS");
        System.out.print("Enter a sample string (e.g., hello): ");
        String sample = sc.nextLine();
        stringTutorial(sample);

        // String palindrome quick check using two-pointer (no extra space)
        printHeader("STRING PALINDROME CHECK (two-pointer)");
        System.out.print("Enter a string to check palindrome: ");
        String p = sc.nextLine().trim();
        boolean isPal = true;
        for (int i = 0, j = p.length() - 1; i < j; i++, j--) {
            if (p.charAt(i) != p.charAt(j)) {
                isPal = false;
                break;
            }
        }
        System.out.println("Is \"" + p + "\" palindrome? " + isPal);

        // COMMON PITFALLS & TIPS
        printHeader("COMMON PITFALLS & TIPS");
        System.out.println("- Java arrays are fixed-size. Use ArrayList for dynamic behavior.");
        System.out.println("- Accessing arr[i] with invalid i throws ArrayIndexOutOfBoundsException.");
        System.out.println("- Use Arrays.toString(arr) to print primitive arrays nicely.");
        System.out.println("- Strings are immutable: operations produce new String objects.");
        System.out.println("- Compare strings with equals(), NOT with == (== checks reference).");
        System.out.println("- Use StringBuilder for heavy concatenation.");

        // Short summary
        printHeader("SUMMARY (one-line each)");
        System.out.println("Array: contiguous, fixed-size, O(1) random access via index, O(n) search.");
        System.out.println("ArrayList: dynamic, backed by array, amortized O(1) append, O(n) remove at index.");
        System.out.println("String: immutable sequence of chars, use StringBuilder for mutations.");

        sc.close();
        System.out.println("\n=== End of Arrays & Strings Demo ===");
    }
}
