// Given an array of N integers, write a program to implement the Recursive Bubble Sort algorithm.

public class Recursive_Bubble_Sort {
    public void recursive_bubble_sort(int[] arr, int n) {
        if (n == 1)
            return;
        boolean didSwap = false;

        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                didSwap = true;
            }
        }
        if (didSwap == false)
            return;
        recursive_bubble_sort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 52, 20, 9 };
        int n = arr.length;

        Recursive_Bubble_Sort obj = new Recursive_Bubble_Sort();
        obj.recursive_bubble_sort(arr, n);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
