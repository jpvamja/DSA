// Given an array of N integers, write a program to implement the Selection sorting algorithm.

public class Selection_Sort {
    public void selection_sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 13, 46, 24, 52, 20, 9 };
        int n = arr.length;

        Selection_Sort obj = new Selection_Sort();

        obj.selection_sort(arr, n);
    }
}
