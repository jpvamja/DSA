// Given an array of integers called nums, sort the array in non-decreasing order using the insertion sort algorithm and return the sorted array.

public class Insertion_Sort {
    public void insertion_sort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 13, 46, 24, 52, 20, 9 };
        int n = arr.length;

        Insertion_Sort obj = new Insertion_Sort();

        obj.insertion_sort(arr, n);
    }
}
