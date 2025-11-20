// You are given an array. The task is to reverse the array and print it. 

import java.util.Scanner;

public class Q06 {
    public void reverseArray(int arr[], int i, int n) {
        if (i >= n / 2) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;

        reverseArray(arr, i + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Original Array");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Q06 obj = new Q06();
        obj.reverseArray(arr, 0, n);

        System.out.println("Reversed Array");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
