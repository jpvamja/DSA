// You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.

public class Q07 {

    public void MoveZerosToEnd(int[] arr, int n) {

        int j = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1)
            return;

        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 5, 5, 1 };

        int n = arr.length;

        Q07 obj = new Q07();
        obj.MoveZerosToEnd(arr, n);

    }
}
