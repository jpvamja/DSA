// Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.

public class Q12 {
    public int getSingleElement(int[] arr, int n) {

        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }

        return xor;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 1, 4, 5, 5, 2, 2 };
        int n = arr.length;

        Q12 obj = new Q12();
        int num = obj.getSingleElement(arr, n);
        System.out.println(num);
    }
}
