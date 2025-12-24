// Given an integer array nums of size n, return the majority element of the array.

public class Q03 {
    public int majorityElement(int[] arr, int n) {
        int count = 0;
        int element = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            } else if (element == arr[i]) {
                count++;
            } else {
                count--;
            }
        }

        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                count1++;
            }
        }

        if (count1 > (n / 2)) {
            return element;
        }

        return -1;

    }

    public static void main(String[] args) {

        int[] arr = { 7, 0, 0, 1, 7, 7, 2, 7, 7 };
        int n = arr.length;

        Q03 obj = new Q03();

        int ans = obj.majorityElement(arr, n);
        System.out.println(ans);

    }
}
