// Given an array, we have to find the largest element in the array.

public class Q01 {
    public int findLargestElement(int[] arr, int n) {
        int max = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = { 8, 10, 5, 7, 9 };
        int n = arr.length;

        Q01 obj = new Q01();
        int large = obj.findLargestElement(arr, n);

        System.out.println(large);
    }
}
