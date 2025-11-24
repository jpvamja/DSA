/*
 * HashingTutorial.java
 * A single-file Java tutorial that demonstrates the concepts from your
 * message: brute-force counting, array-based hashing (fixed-range),
 * character hashing, using HashMap for large numbers, the division method
 * (bucket hashing) and chaining to resolve collisions.
 *
 * How to use:
 * - Read the comments and methods below. The main() includes example runs
 *   for each approach. You can change inputs there or provide input via
 *   Scanner if you prefer interactive runs.
 *
 * Key methods:
 *  - bruteForceCount(int[] arr, int x)
 *  - arrayHashCount(int[] arr, int maxVal, int q)   // fixed-range array hashing
 *  - charHashLowercase(String s, char q)           // only 'a'..'z'
 *  - charHashFullAscii(String s, char q)           // full 0..255 ASCII
 *  - hashMapCount(int[] arr, int q)                // works for large numbers
 *  - divisionMethodBuckets(int[] arr, int modulo, int q) // bucket + chaining
 *
 * Complexity notes are included in comments above each method.
 */

import java.util.*;

public class HashingTutorial {

    /* ------------------------- BRUTE FORCE ------------------------- */
    // For each query q, scan the entire array and count occurrences.
    // Time complexity for one query: O(N). For Q queries: O(N * Q).
    public static int bruteForceCount(int[] arr, int x) {
        int cnt = 0;
        for (int v : arr)
            if (v == x)
                cnt++;
        return cnt;
    }

    /* --------------------- ARRAY-BASED HASHING --------------------- */
    // Works when all values are small and non-negative (<= maxVal).
    // Precompute frequencies in O(N) time and O(maxVal+1) space.
    // Each query answered in O(1).
    public static int[] arrayHashBuild(int[] arr, int maxVal) {
        int[] hash = new int[maxVal + 1];
        for (int v : arr) {
            if (v >= 0 && v <= maxVal)
                hash[v]++;
            else {
                // Optionally handle out-of-range values
                System.err.println("Warning: value out of range for array-hash: " + v);
            }
        }
        return hash;
    }

    /* --------------------- CHARACTER HASHING ---------------------- */
    // Lowercase-only example: map 'a'->0 .. 'z'->25 using (ch - 'a')
    // Precompute in O(L) where L = string length. Answer each query O(1).
    public static int[] charHashLowercaseBuild(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                hash[ch - 'a']++;
            else
                System.err.println("Non-lowercase character found: " + ch);
        }
        return hash;
    }

    // Full ASCII (0..255) version — safe for mixed-case and symbols.
    public static int[] charHashAsciiBuild(String s) {
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        return hash;
    }

    /* ---------------------- HashMap (large numbers) ---------------------- */
    // Use Java's HashMap to store frequencies -> works for very large keys.
    // Average time: O(1) per insert/lookup. Worst-case O(n) but rare.
    public static Map<Integer, Integer> hashMapBuild(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : arr) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        return mp;
    }

    /* ---------------------- Division method + Chaining ------------------ */
    // We pick a small modulo (number of buckets). Each bucket stores a list
    // of elements that hashed to that bucket. To answer frequency queries,
    // we look into bucket (key % modulo) and count occurrences of key.
    // This simulates how many hash-table implementations work conceptually.
    public static List<List<Integer>> buildBucketsWithChaining(int[] arr, int modulo) {
        // modulo must be > 0
        List<List<Integer>> buckets = new ArrayList<>(modulo);
        for (int i = 0; i < modulo; i++)
            buckets.add(new ArrayList<>());
        for (int v : arr) {
            int idx = Math.floorMod(v, modulo); // handles negatives safely
            buckets.get(idx).add(v);
        }
        // Optionally sort each bucket for faster repeated lookups (binary search)
        for (List<Integer> b : buckets)
            Collections.sort(b);
        return buckets;
    }

    // Count occurrences of key using the buckets built above.
    // Time to answer: O(k) where k = size of its bucket.
    public static int countUsingBuckets(List<List<Integer>> buckets, int modulo, int key) {
        int idx = Math.floorMod(key, modulo);
        List<Integer> b = buckets.get(idx);
        // Because we sorted buckets, we can use binary search to find frequency
        // quickly.
        // We'll use two binary searches to find lower/upper bounds.
        int low = lowerBound(b, key);
        int high = upperBound(b, key);
        return high - low;
    }

    // lowerBound: first index where val <= element (i.e., first >= key)
    private static int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a.get(m) < key)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    // upperBound: first index strictly greater than key
    private static int upperBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a.get(m) <= key)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    /* --------------------------- DEMO / MAIN --------------------------- */
    public static void main(String[] args) {
        System.out.println("--- Hashing Tutorial Demo ---\n");

        int[] arr = { 1, 2, 1, 3, 2 };
        int[] queries = { 1, 3, 4, 2, 10 };

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Queries: " + Arrays.toString(queries));
        System.out.println();

        // 1) Brute-force
        System.out.println("Brute-force results:");
        for (int q : queries) {
            System.out.println(q + " -> " + bruteForceCount(arr, q));
        }
        System.out.println();

        // 2) Array-based hashing (assume max value = 12 as in your example)
        int maxVal = 12;
        int[] arrHash = arrayHashBuild(arr, maxVal);
        System.out.println("Array-based hash (precomputed) results:");
        for (int q : queries) {
            if (q >= 0 && q <= maxVal)
                System.out.println(q + " -> " + arrHash[q]);
            else
                System.out.println(q + " -> out of range for array-hash");
        }
        System.out.println();

        // 3) HashMap approach (handles large numbers)
        Map<Integer, Integer> mp = hashMapBuild(arr);
        System.out.println("HashMap results:");
        for (int q : queries)
            System.out.println(q + " -> " + mp.getOrDefault(q, 0));
        System.out.println();

        // 4) Character hashing (lowercase example)
        String s = "abcdabefc";
        char[] cq = { 'a', 'c', 'z' };
        int[] chHash = charHashLowercaseBuild(s);
        System.out.println("String: " + s);
        System.out.println("Character queries:");
        for (char c : cq) {
            if (c >= 'a' && c <= 'z')
                System.out.println(c + " -> " + chHash[c - 'a']);
            else
                System.out.println(c + " -> out of lowercase range");
        }
        System.out.println();

        // 5) Division method + chaining demonstration
        int[] bigArr = { 2, 5, 16, 28, 139, 38, 48, 28, 18 };
        int modulo = 10; // number of buckets
        List<List<Integer>> buckets = buildBucketsWithChaining(bigArr, modulo);
        System.out.println("Division-method buckets (mod " + modulo + "):");
        for (int i = 0; i < buckets.size(); i++) {
            System.out.println(i + ": " + buckets.get(i));
        }
        System.out.println("Count of 28 -> " + countUsingBuckets(buckets, modulo, 28));
        System.out.println();

        System.out.println("--- Complexity Summary ---");
        System.out.println("Brute-force: O(N) per query -> O(N*Q) for Q queries.");
        System.out.println("Array-hash: O(N + maxVal) precompute, O(1) per query (space O(maxVal)).");
        System.out.println("HashMap: O(N) average build, O(1) average per query (handles large keys).");
        System.out.println("Division+chaining: O(N) to build buckets, query cost = O(bucketSize) (worst-case O(N)).");

        System.out.println("\nYou can modify main() to try other inputs.\n");
    }
}
