// Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order. The sorting must be done in-place, without making a copy of the original array.

public class Q02 {
    public void sortZeroOneTwo(int[] arr, int n) {
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 2, 0, 2, 1, 1, 0 };
        int n = arr.length;

        Q02 obj = new Q02();

        obj.sortZeroOneTwo(arr, n);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
