// Given an integer array nums, rotate the array to the left by one.

public class Q05 {
    public void rotateArrayByOne(int[] arr, int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;

        Q05 obj = new Q05();
        obj.rotateArrayByOne(arr, n);
    }
}
