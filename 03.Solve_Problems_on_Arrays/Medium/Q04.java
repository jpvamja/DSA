// Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.

public class Q04 {
    public int maxSubArray(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE;

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5, -2, 7, -4 };
        int n = arr.length;

        Q04 obj = new Q04();

        int ans = obj.maxSubArray(arr, n);
        System.out.println(ans);

    }
}
