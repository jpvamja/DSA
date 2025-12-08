// Given an array of integers, rotating array of elements by k elements either left or right.

public class Q06 {

    public void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public int[] rotateArrayByK(int[] arr, int k, String direction) {
        int n = arr.length;

        if (n == 0)
            return arr;

        k = k % n;
        if (k == 0) {
            return arr;
        }

        if (direction.equals("right")) {
            reverseArray(arr, 0, n - 1);
            reverseArray(arr, 0, k - 1);
            reverseArray(arr, k, n - 1);
        } else if (direction.equals("left")) {
            reverseArray(arr, 0, k - 1);
            reverseArray(arr, k, n - 1);
            reverseArray(arr, 0, n - 1);
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };

        String direction = "right";

        int k = 3;

        Q06 obj = new Q06();
        int[] result = obj.rotateArrayByK(arr, k, direction);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
