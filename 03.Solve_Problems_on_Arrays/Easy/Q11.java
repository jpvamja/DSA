// Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.

public class Q11 {
    public int findMaxConsecutive(int[] arr, int n) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 1, 1, 1, 1, 0, 1 };
        int n = arr.length;

        Q11 obj = new Q11();
        int count = obj.findMaxConsecutive(arr, n);
        System.out.println(count);
    }
}
