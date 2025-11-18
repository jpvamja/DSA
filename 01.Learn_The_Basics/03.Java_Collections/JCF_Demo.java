/*
💡 Java Collections Framework — Complete Overview and Examples
--------------------------------------------------------------

📘 Why Collections?
Arrays are fixed in size and lack built-in utilities like sorting, searching, or resizing.
Java Collections Framework (JCF) provides dynamic, flexible data structures that can grow/shrink,
and comes with rich APIs for data manipulation.

⚙️ Framework Hierarchy:
Iterable → Collection → [List, Set, Queue]
Map (separate branch — key-value pairs)

---------------------------------------------
 Major Interfaces & Implementations
---------------------------------------------
List:     Ordered, allows duplicates (ArrayList, LinkedList, Vector)
Set:      Unordered, unique elements (HashSet, LinkedHashSet, TreeSet)
Queue:    FIFO or priority-based (ArrayDeque, PriorityQueue)
Map:      Key-value pairs (HashMap, LinkedHashMap, TreeMap)

Also includes helper classes: Collections, Arrays
---------------------------------------------
*/

import java.util.*; // Importing the entire Collections framework

public class JCF_Demo {

    public static void main(String[] args) {
        // ==============================
        // 🧱 1. LIST INTERFACE
        // ==============================
        System.out.println("=== LIST EXAMPLES ===");
        List<String> names = new ArrayList<>(); // dynamic array
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Bob"); // duplicates allowed
        System.out.println("ArrayList: " + names);

        // LinkedList example
        List<String> linkedList = new LinkedList<>(names);
        linkedList.addFirst("Zara");
        linkedList.addLast("David");
        System.out.println("LinkedList: " + linkedList);

        // Vector example (thread-safe)
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        vector.add(30);
        System.out.println("Vector: " + vector);

        // ==============================
        // 🧩 2. SET INTERFACE
        // ==============================
        System.out.println("\n=== SET EXAMPLES ===");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("Python");
        hashSet.add("C++");
        hashSet.add("Java"); // duplicate ignored
        System.out.println("HashSet (unordered): " + hashSet);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Java");
        linkedHashSet.add("Python");
        linkedHashSet.add("C++");
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);

        Set<String> treeSet = new TreeSet<>(linkedHashSet);
        System.out.println("TreeSet (sorted order): " + treeSet);

        // ==============================
        // 🧮 3. MAP INTERFACE
        // ==============================
        System.out.println("\n=== MAP EXAMPLES ===");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Apple");
        hashMap.put(2, "Banana");
        hashMap.put(3, "Cherry");
        hashMap.put(2, "Blueberry"); // replaces existing value
        System.out.println("HashMap: " + hashMap);

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Cat");
        linkedHashMap.put(1, "Dog");
        linkedHashMap.put(2, "Elephant");
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);

        Map<Integer, String> treeMap = new TreeMap<>(linkedHashMap);
        System.out.println("TreeMap (sorted by key): " + treeMap);

        // Accessing keys, values, and entries
        System.out.println("Keys: " + treeMap.keySet());
        System.out.println("Values: " + treeMap.values());
        System.out.println("Entries: " + treeMap.entrySet());

        // ==============================
        // ⚙️ 4. QUEUE / DEQUE
        // ==============================
        System.out.println("\n=== QUEUE / DEQUE EXAMPLES ===");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("Queue (FIFO): " + queue);
        queue.poll();
        System.out.println("After poll(): " + queue);

        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("Front");
        deque.offerLast("Back");
        deque.offer("Middle");
        System.out.println("Deque: " + deque);
        deque.pollLast();
        System.out.println("Deque after pollLast(): " + deque);

        // ==============================
        // 🔒 5. CONCURRENT COLLECTIONS
        // ==============================
        System.out.println("\n=== CONCURRENT COLLECTION EXAMPLES ===");
        Map<String, Integer> concurrentMap = new java.util.concurrent.ConcurrentHashMap<>();
        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        System.out.println("ConcurrentHashMap: " + concurrentMap);

        List<String> threadSafeList = new java.util.concurrent.CopyOnWriteArrayList<>();
        threadSafeList.add("X");
        threadSafeList.add("Y");
        System.out.println("CopyOnWriteArrayList: " + threadSafeList);

        // ==============================
        // 🧠 6. GENERICS AND TYPE SAFETY
        // ==============================
        System.out.println("\n=== GENERICS EXAMPLE ===");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        // numbers.add("Hello"); // ❌ Compile-time error
        System.out.println("Generic List<Integer>: " + numbers);

        // ==============================
        // 🧰 7. COLLECTIONS UTILITY CLASS
        // ==============================
        System.out.println("\n=== COLLECTIONS UTILITY METHODS ===");
        List<Integer> nums = Arrays.asList(3, 1, 4, 2);
        System.out.println("Original: " + nums);

        List<Integer> mutableNums = new ArrayList<>(nums);
        Collections.sort(mutableNums);
        System.out.println("Sorted: " + mutableNums);

        Collections.reverse(mutableNums);
        System.out.println("Reversed: " + mutableNums);

        Collections.shuffle(mutableNums);
        System.out.println("Shuffled: " + mutableNums);

        System.out.println("Min: " + Collections.min(mutableNums));
        System.out.println("Max: " + Collections.max(mutableNums));

        // ==============================
        // 🧩 8. INTERNAL WORKING SUMMARY
        // ==============================
        System.out.println("\n=== INTERNAL WORKING SUMMARY ===");
        System.out.println("""
                - HashMap / HashSet → use hash table (O(1) average insert/search)
                - TreeMap / TreeSet → use Red-Black Tree (O(log n) operations)
                - ArrayList → uses a dynamic resizable array
                - LinkedList → uses doubly linked nodes
                - Collections class → provides utility methods (sort, reverse, etc.)
                """);

        // ==============================
        // ✅ 9. SUMMARY TABLE (Quick Reference)
        // ==============================
        System.out.println("\n=== SUMMARY TABLE ===");
        System.out.println("""
                Interface | Implementations           | Order            | Duplicates | Use Case
                ----------|---------------------------|------------------|------------|-------------------------
                List      | ArrayList, LinkedList     | Ordered          | Yes        | Ordered data, indexing
                Set       | HashSet, TreeSet          | Unordered/Sorted | No         | Unique items
                Queue     | LinkedList, PriorityQueue | FIFO/Priority    | Yes        | Task scheduling
                Map       | HashMap, TreeMap          | Key-Value Sorted | Keys unique| Fast lookup by key
                """);
    }
}
