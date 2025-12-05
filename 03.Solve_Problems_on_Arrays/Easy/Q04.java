// Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.

public class Q04 {

    public int removeDuplicates(int[] arr, int n) {

        if (n == 0)
            return 0;

        int i = 0;

        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 1, 2, 2, 2, 3, 3 };
        int n = arr.length;

        Q04 obj = new Q04();
        int count = obj.removeDuplicates(arr, n);

        System.out.println("Unique count = " + count);
        for (int x = 0; x < count; x++) {
            System.out.print(arr[x] + " ");
        }

    }
}
