// Given an array, and an element num the task is to find if num is present in the given array or not. If present print the index of the element or print -1.

public class Q08 {

    public int LinearSearch(int[] arr, int n, int num) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 6, 8, 4, 5, 6 };
        int num = 4;

        int n = arr.length;

        Q08 obj = new Q08();
        int index = obj.LinearSearch(arr, n, num);

        System.out.println(index);
    }
}
