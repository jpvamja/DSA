// Given an array of integers arr[] and an integer target.

// 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

// 2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

import java.util.Arrays;

public class Q01 {
    public String twoSumExists(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target)
                return "YES";
            else if (sum < target)
                left++;
            else
                right--;
        }
        return "NO";
    }

    public int[] twoSumIndices(int[] arr, int target) {
        int n = arr.length;
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = arr[i];
            a[i][1] = i;
        }

        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = a[left][0] + a[right][0];
            if (sum == target) {
                return new int[] { a[left][1], a[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        Q01 obj = new Q01();
        int[] arr = { 2, 6, 5, 8, 11 };
        int target = 14;

        System.out.println(obj.twoSumExists(arr, target));

        int[] res = obj.twoSumIndices(arr, target);
        System.out.println(res);
    }
}
