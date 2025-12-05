// Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. If the array is sorted then return True, Else return False.

public class Q03 {

    public boolean isSorted(int[] arr, int n) {
        if (n < 2)
            return true;

        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1])
                inc = false;
            if (arr[i] < arr[i + 1])
                dec = false;

            if (!inc && !dec)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 5, 9 };
        int n = arr.length;

        Q03 obj = new Q03();
        boolean sorted = obj.isSorted(arr, n);

        System.out.println(sorted);
    }
}
