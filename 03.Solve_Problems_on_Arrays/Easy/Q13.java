// Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.

public class Q13 {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        int left = 0, right = 0;

        int sum = nums[0];

        while (right < n) {

            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
            if (right < n) {
                sum += nums[right];
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int k = 15;

        Q13 obj = new Q13();
        int ans = obj.longestSubarray(arr, k);

        System.out.println(ans);
    }
}
