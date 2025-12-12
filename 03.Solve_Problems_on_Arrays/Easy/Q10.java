// Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.

public class Q10 {
    public int findMissingNo(int[] arr, int n) {

        // solution1
        // int sum = (n * (n + 1)) / 2;
        // int actualSum = 0;
        // for (int i = 0; i < n - 1; i++) {
        // actualSum += arr[i];
        // }
        // return sum - actualSum;

        // solution2
        int xor1 = 0;
        int xor2 = 0;

        for (int i = 0; i < n - 1; i++) {
            xor2 ^= arr[i];
            xor1 ^= (i + 1);
        }
        xor1 ^= n;

        return xor1 ^ xor2;

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 4, 5 };
        int n = arr.length + 1;

        Q10 obj = new Q10();
        int num = obj.findMissingNo(arr, n);
        System.out.println(num);
    }
}
