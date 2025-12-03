// Given an array of N integers, write a program to implement the Recursive Insertion Sort algorithm.

public class Recursive_Insertion_Sort {
    public void recursive_insertion_sort(int[] arr, int i, int n) {
        if (i == n)
            return;

        int j = i;

        while (j > 0 && arr[j - 1] > arr[j]) {
            // Swap arr[j] and arr[j-1]
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }

        recursive_insertion_sort(arr, i + 1, n);
    }

    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 52, 20, 9 };
        int n = arr.length;

        Recursive_Insertion_Sort obj = new Recursive_Insertion_Sort();
        obj.recursive_insertion_sort(arr, 0, n);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
