// PassByDemo.java
// Single-file tutorial showing how Java passes arguments to methods.
// Author: Jeet Vamja
//
// Key idea (short): Java is ALWAYS pass-by-value.
//  - For primitives: the *value* is the primitive itself -> copies are passed.
//  - For objects: the *value* is a reference (pointer) to the object -> a copy of the reference is passed.
//    This makes it *look* like pass-by-reference because you can modify object fields through that reference,
//    but reassigning the parameter reference inside the method does NOT change the caller's reference.

public class PassByDemo {
    // Simple wrapper class to demonstrate object field mutation
    static class Wrapper {
        int value;
        Wrapper(int v) { value = v; }
        @Override
        public String toString() { return "Wrapper(" + value + ")"; }
    }

    // -------------- Examples for primitives --------------
    static void modifyPrimitive(int a) {
        // 'a' is a local copy of the caller's value
        System.out.println("Inside modifyPrimitive - before: a = " + a);
        a = a + 10; // modifies local copy only
        System.out.println("Inside modifyPrimitive - after : a = " + a);
    }

    static void trySwapPrimitives(int x, int y) {
        // swapping local copies — caller's variables remain unchanged
        System.out.println("Inside trySwapPrimitives - before: x=" + x + ", y=" + y);
        int temp = x; x = y; y = temp;
        System.out.println("Inside trySwapPrimitives - after : x=" + x + ", y=" + y);
    }

    // -------------- Examples for objects (reference semantics) --------------
    static void modifyObjectField(Wrapper w) {
        // 'w' is a copy of the reference, but it points to the same object
        System.out.println("Inside modifyObjectField - before: w = " + w);
        w.value += 10; // mutates the object that both caller and callee refer to
        System.out.println("Inside modifyObjectField - after : w = " + w);
    }

    static void reassignObjectReference(Wrapper w) {
        // reassigning the local reference does NOT affect caller's reference
        System.out.println("Inside reassignObjectReference - before: w = " + w);
        w = new Wrapper(999); // this only changes the local copy of the reference
        System.out.println("Inside reassignObjectReference - after : w = " + w);
    }

    static void trySwapReferences(Wrapper a, Wrapper b) {
        // attempt to swap references (only swaps local copies)
        System.out.println("Inside trySwapReferences - before: a=" + a + ", b=" + b);
        Wrapper tmp = a; a = b; b = tmp;
        System.out.println("Inside trySwapReferences - after : a=" + a + ", b=" + b);
    }

    // Proper way to swap "values" stored inside wrappers (mutate fields)
    static void swapWrapperValues(Wrapper a, Wrapper b) {
        System.out.println("Inside swapWrapperValues - before: a=" + a + ", b=" + b);
        int tmp = a.value; a.value = b.value; b.value = tmp;
        System.out.println("Inside swapWrapperValues - after : a=" + a + ", b=" + b);
    }

    // -------------- Strings (immutable) --------------
    static void modifyString(String s) {
        System.out.println("Inside modifyString - before: s = \"" + s + "\"");
        s = s + "!!!"; // creates a new String object and assigns to local variable s
        System.out.println("Inside modifyString - after : s = \"" + s + "\"");
    }

    // -------------- Returning multiple values (common patterns) --------------
    // 1) Return an array
    static int[] divideAndRemainder(int n, int d) {
        return new int[] { n / d, n % d };
    }

    // 2) Use a simple holder object (like Wrapper)
    static Wrapper[] divideAndRemainderHolder(int n, int d) {
        Wrapper q = new Wrapper(n / d);
        Wrapper r = new Wrapper(n % d);
        return new Wrapper[] { q, r };
    }

    // -------------- Main demo --------------
    public static void main(String[] args) {
        System.out.println("=== Pass-By Demo (Java semantics) ===\n");

        // PRIMITIVE example
        int num = 5;
        System.out.println("Main before modifyPrimitive: num = " + num);
        modifyPrimitive(num);
        System.out.println("Main after modifyPrimitive : num = " + num);
        System.out.println("-> Primitive unchanged because method worked on a copy.\n");

        // TRY to swap primitives
        int p = 10, q = 20;
        System.out.println("Main before trySwapPrimitives: p = " + p + ", q = " + q);
        trySwapPrimitives(p, q);
        System.out.println("Main after trySwapPrimitives : p = " + p + ", q = " + q);
        System.out.println("-> Swap failed because only copies were swapped.\n");

        // OBJECT field mutation example
        Wrapper w = new Wrapper(7);
        System.out.println("Main before modifyObjectField: w = " + w);
        modifyObjectField(w);
        System.out.println("Main after modifyObjectField : w = " + w);
        System.out.println("-> Object mutated because method changed the object's field via the reference.\n");

        // Reassigning reference inside method DOES NOT change caller's reference
        System.out.println("Main before reassignObjectReference: w = " + w);
        reassignObjectReference(w);
        System.out.println("Main after reassignObjectReference : w = " + w);
        System.out.println("-> Local reassignment didn't affect caller's variable.\n");

        // Try swapping object references (will not swap caller references)
        Wrapper a = new Wrapper(1);
        Wrapper b = new Wrapper(2);
        System.out.println("Main before trySwapReferences: a = " + a + ", b = " + b);
        trySwapReferences(a, b);
        System.out.println("Main after trySwapReferences : a = " + a + ", b = " + b);
        System.out.println("-> References not swapped because method only swapped local copies.\n");

        // Swap wrapper values (this works because we mutate fields)
        System.out.println("Main before swapWrapperValues: a = " + a + ", b = " + b);
        swapWrapperValues(a, b);
        System.out.println("Main after swapWrapperValues : a = " + a + ", b = " + b);
        System.out.println("-> Values swapped by mutating object fields.\n");

        // STRING immutability example
        String str = "Hello";
        System.out.println("Main before modifyString: str = \"" + str + "\"");
        modifyString(str);
        System.out.println("Main after modifyString : str = \"" + str + "\"");
        System.out.println("-> String unchanged (immutable). modifyString created a new String locally.\n");

        // Returning multiple values: array
        int n = 17, d = 5;
        int[] qr = divideAndRemainder(n, d);
        System.out.println("divideAndRemainder(" + n + "," + d + ") -> quotient=" + qr[0] + ", remainder=" + qr[1]);

        // Returning multiple values: holder objects
        Wrapper[] holders = divideAndRemainderHolder(n, d);
        System.out.println("divideAndRemainderHolder -> quotient=" + holders[0] + ", remainder=" + holders[1]);

        // SUMMARY: quick printed recap
        System.out.println("\n=== Summary (Java) ===");
        System.out.println("- Java is PASS-BY-VALUE only.");
        System.out.println("- For primitives: the value is copied. Methods cannot change caller's primitive variables.");
        System.out.println("- For objects: the value passed is a REFERENCE (address). The reference itself is copied.");
        System.out.println("  • Methods can mutate object state via that reference (visible to caller).");
        System.out.println("  • Methods cannot reassign the caller's reference by assigning the parameter to a new object.");
        System.out.println("- Strings are immutable: methods that 'modify' Strings create new objects.");
        System.out.println("- To 'return multiple values' either return an array/object, or mutate passed mutable objects.\n");

        System.out.println("=== End of Demo ===");
    }
}
