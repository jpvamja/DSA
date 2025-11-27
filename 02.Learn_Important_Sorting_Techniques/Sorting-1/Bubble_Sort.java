// Given an array of N integers, write a program to implement the Bubble Sorting algorithm.

public class Bubble_Sort {
    public void bubble_sort(int[] arr, int n) {
        for (int i = n - 1; i > 0; i--) {
            boolean didSwap = false;

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = true;
                }
            }

            if (!didSwap) {
                break;
            }
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 13, 46, 24, 52, 20, 9 };
        int n = arr.length;

        Bubble_Sort obj = new Bubble_Sort();

        obj.bubble_sort(arr, n);
    }
}
