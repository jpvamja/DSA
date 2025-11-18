// This file contains:
//  - short theory notes (as comments / printed output)
//  - examples demonstrating O(1), O(N), O(N^2), O(log N), O(N log N)
//  - operation-count based demos (to visualize growth)
//  - space complexity examples (O(1), O(N), recursion stack)
//  - tips: worst-case, ignoring constants, dropping lower terms, 1e8 ops/sec heuristic
//
// IMPORTANT: This program counts elementary operations to illustrate growth.
// Real runtime depends on machine; complexity is about how counts scale with N.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ComplexityDemo {

    // -------------------------
    // Helper: print a note header
    // -------------------------
    private static void header(String title) {
        System.out.println("\n=== " + title + " ===");
    }

    // -------------------------
    // O(1) example: constant-time
    // -------------------------
    // Returns number of simple operations executed
    static long exampleConstant(int n) {
        // regardless of n, we do a fixed number of ops
        long ops = 0;
        ops++; // assignment
        ops++; // comparison
        ops++; // return
        return ops; // this number doesn't grow with n -> O(1)
    }

    // -------------------------
    // O(N) example: linear-time loop
    // -------------------------
    static long exampleLinear(int n) {
        long ops = 0;
        int sum = 0; // 1 op
        ops++;
        for (int i = 0; i < n; i++) { // approx n iterations
            sum += i; // 1 op per iteration (addition)
            ops += 1;
        }
        ops++; // final return/assignment
        return ops; // ~ n + constant -> O(n)
    }

    // -------------------------
    // O(N^2) example: nested loops
    // -------------------------
    static long exampleQuadratic(int n) {
        long ops = 0;
        for (int i = 0; i < n; i++) {
            ops++; // outer increment
            for (int j = 0; j < n; j++) {
                ops++; // inner op
            }
        }
        return ops; // ~ n*n -> O(n^2)
    }

    // -------------------------
    // O(log N) example: binary search (count steps)
    // -------------------------
    static long exampleLogarithmic(int n) {
        // We'll simulate binary search count: how many times can we halve until 1
        long ops = 0;
        int length = n > 0 ? n : 1;
        while (length > 1) {
            length /= 2;
            ops++;
        }
        // For n = 2^k, ops = k = log2(n)
        return ops; // O(log n)
    }

    // -------------------------
    // O(N log N) example: sort cost approximation
    // -------------------------
    static long exampleNLogN(int n) {
        // We won't sort huge arrays here; we return an estimate: n * log2(n)
        if (n <= 1)
            return 0;
        double est = n * (Math.log(n) / Math.log(2)); // n * log2(n)
        return (long) Math.round(est);
    }

    // -------------------------
    // Summation example: 1 + 2 + ... + N => O(N^2)
    // shows triangular loops behavior
    // -------------------------
    static long exampleTriangular(int n) {
        long ops = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                ops++;
            }
        }
        return ops; // ~ n*(n+1)/2 => O(n^2)
    }

    // -------------------------
    // SPACE EXAMPLES
    // -------------------------
    // constant extra space O(1)
    static int[] spaceConstantExample(int n) {
        // uses a fixed number of primitive variables and returns a single int[] of size
        // 1
        int a = 0, b = 1;
        return new int[] { a + b }; // auxiliary O(1) array of size 1
    }

    // linear extra space O(n)
    static int[] spaceLinearExample(int n) {
        // creates an array of size n -> O(n) auxiliary space
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr; // caller can inspect length
    }

    // recursion depth example -> space complexity O(n) due to call stack
    static int recursionDepthExample(int n) {
        if (n <= 0)
            return 0;
        return 1 + recursionDepthExample(n - 1); // uses O(n) stack frames
    }

    // -------------------------
    // Demonstration runner
    // -------------------------
    public static void runDemos(int n) {
        header("Summary of Theoretical Rules (printed)");
        System.out.println("1) Always analyze worst-case unless asked otherwise.");
        System.out.println("2) Drop constant factors (O(3N) -> O(N)).");
        System.out.println("3) Drop lower order terms (O(N^2 + N) -> O(N^2)).");
        System.out.println("4) Big-O describes how ops grow with input size N, not absolute time.\n");

        header("Operation count examples for N = " + n);
        System.out.println("O(1) example -> ops = " + exampleConstant(n));
        System.out.println("O(N) example -> ops ≈ " + exampleLinear(n));
        System.out.println("O(N^2) example -> ops ≈ " + exampleQuadratic(n));
        System.out.println("O(log N) example (binary-halving) -> ops ≈ " + exampleLogarithmic(n));
        System.out.println("O(N log N) estimate (sorting) -> ops ≈ " + exampleNLogN(n));
        System.out.println("Triangular (1+2+...+N) -> ops ≈ " + exampleTriangular(n));

        header("Space complexity examples (auxiliary)");
        int[] c = spaceConstantExample(n);
        System.out.println("O(1) example: returned array length = " + c.length + " (constant)");
        int[] lin = spaceLinearExample(Math.max(0, n));
        System.out.println("O(N) example: created array length = " + lin.length + " (linear)");
        int depth = n <= 20 ? recursionDepthExample(n) : -1; // avoid deep recursion when n large
        System.out.println("Recursion depth example (stack) for n <= 20: " + (depth == -1 ? "skipped (n>20)" : depth));

        header("Worked examples & reasoning");
        System.out.println("Example: for (i=0..N-1) for (j=0..N-1) => N*N ops => O(N^2)");
        System.out.println("Example: for (i=0..N-1) for (j=0..i) => 1+2+..+N => O(N^2) (triangular sum)");
        System.out.println("Example: binary search halves each step => O(log N)");
        System.out.println("Example: MergeSort/QuickSort average => O(N log N) (divide & conquer)");
        System.out.println();

        header("Complexity classes quick reference");
        System.out.println("O(1)   constant");
        System.out.println("O(log n) logarithmic");
        System.out.println("O(n) linear");
        System.out.println("O(n log n) linearithmic");
        System.out.println("O(n^2) quadratic");
        System.out.println("O(2^n) exponential (usually not scalable)");
        System.out.println();

        header("Practical Competitive-Programming Heuristic");
        System.out.println("Online judges: ~1e8 elementary ops ≈ 1 second (rough).");
        System.out.println("Therefore: O(N^2) might be fine for N up to ~10^4? (depends on constant)");
        System.out.println("More safe heuristics:");
        System.out.println(" - O(N)  up to 1e8 is fine");
        System.out.println(" - O(N log N) up to ~1e7-1e8 (depends)");
        System.out.println(" - O(N^2) only up to ~1e4 (depends on constants)");
        System.out.println("Always test with worst-case large inputs and check time limit.\n");

        header("How to reason about algorithm complexity (quick checklist)");
        System.out.println("1) Count loops and nesting depth.");
        System.out.println("2) For recursive functions: write recurrence T(n) and solve (Master theorem etc.).");
        System.out.println("3) Identify extra memory: arrays, hash maps, recursion stack => space complexity.");
        System.out.println("4) Remove constants and lower-order terms for Big-O.");
        System.out.println();

        header("Common pitfalls");
        System.out.println("- Don't equate measured runtime directly to Big-O (different machines/IO/etc).");
        System.out.println("- Beware hidden costs: Java's sort has O(n log n) with sizable constant.");
        System.out.println("- Memory limits matter: O(n) arrays for n=1e8 may blow memory.");
        System.out
                .println("- For recursion, beware stack overflow for deep recursion (use loops or tail recursion).\n");
    }

    // -------------------------
    // Small micro-benchmark (shows growth but caution: depends on machine)
    // We'll run tiny loops for demonstration only.
    // -------------------------
    static void microBenchmark(int n) {
        header("MICRO BENCHMARK (Wall-clock) - Demonstration only");
        System.out.println("Note: runtime will vary by machine and JVM; complexity is about growth, not time.");

        int[] arr = new int[n];
        Random rnd = new Random(1);

        // Prepare array
        for (int i = 0; i < n; i++)
            arr[i] = rnd.nextInt();

        // --- O(N) pass ---
        long t0 = System.nanoTime();
        long s = 0;
        for (int i = 0; i < n; i++)
            s += arr[i];
        long t1 = System.nanoTime();
        System.out.printf("O(N) pass: n=%d took %.3f ms\n", n, (t1 - t0) / 1e6);

        // --- O(N log N) sort ---
        int[] copy = Arrays.copyOf(arr, arr.length);
        long t2 = System.nanoTime();
        Arrays.sort(copy); // usually O(n log n)
        long t3 = System.nanoTime();
        System.out.printf("Sort (n log n) for n=%d took %.3f ms\n", n, (t3 - t2) / 1e6);

        // --- O(N^2) tiny demonstration (only if n small!) ---
        if (n <= 2000) {
            long t4 = System.nanoTime();
            long cnt = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    cnt++;
            long t5 = System.nanoTime();
            System.out.printf("O(N^2) double-loop for n=%d took %.3f ms (cnt=%d)\n", n, (t5 - t4) / 1e6, cnt);
        } else {
            System.out.println("Skipping micro O(N^2) run because n is too large for demo.");
        }
    }

    // -------------------------
    // Interactive main
    // -------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("COMPLEXITY DEMO (Time & Space) — Interactive study file");
        System.out.println("You'll be prompted for a sample N to see counts/estimates.");
        System.out.println("Read the printed notes inside code for theory and rules.\n");

        System.out.print("Enter a small-ish N for demonstration (e.g., 10 or 100): ");
        int n = 0;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid input, using N=10");
            n = 10;
        }

        // Run operation-count demos
        runDemos(n);

        // Micro benchmark (optional)
        System.out.print("\nDo you want to run a tiny micro-benchmark (measures time) ? (y/n): ");
        String ans = sc.nextLine().trim().toLowerCase();
        if (ans.equals("y") || ans.equals("yes")) {
            System.out.print("Enter n for benchmark (use small values like 1000 or 10000): ");
            int bn = 1000;
            try {
                bn = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception ignored) {
            }
            microBenchmark(bn);
        }

        // Quick exercises for practice
        header("PRACTICE EXERCISES (for self-study)");
        System.out.println("1) Write a function that checks if an array has duplicates. Analyze best/worst case.");
        System.out.println("2) Implement binary search and reason about O(log n). Try with sorted arrays.");
        System.out.println("3) Implement MergeSort, count comparisons, and verify ~ n log n growth.");
        System.out.println("4) For recursion: solve Fibonacci recursively and iteratively; compare complexities.");
        System.out.println();

        header("FINAL TIPS");
        System.out.println("- Memorize common complexities (O(1), O(log n), O(n), O(n log n), O(n^2)).");
        System.out.println("- Practice deriving complexity by counting loops, recursion depth, and extra space.");
        System.out.println("- For competitive programming, aim for O(n log n) or better unless N is small.");
        System.out.println(
                "- In interviews, explain worst-case, mention space complexity, and show the reasoning steps.\n");

        sc.close();
        System.out.println("End of ComplexityDemo. Happy learning!");
    }
}
