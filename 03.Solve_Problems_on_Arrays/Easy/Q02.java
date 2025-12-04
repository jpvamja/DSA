// Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.

public class Q02 {
    public int findSecondLargestElement(int[] arr, int n) {

        if (n < 2)
            return -1;

        int largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                second_largest = largest;
                largest = arr[i];
            } else if (arr[i] > second_largest && arr[i] != largest) {
                second_largest = arr[i];
            }
        }

        return second_largest;
    }

    public int findSecondSmallestElement(int[] arr, int n) {

        if (n < 2)
            return -1;

        int smallest = Integer.MAX_VALUE;
        int second_smallest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                second_smallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < second_smallest && arr[i] != smallest) {
                second_smallest = arr[i];
            }
        }

        return second_smallest;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 4, 7, 7, 5 };
        int n = arr.length;

        Q02 obj = new Q02();
        int sL = obj.findSecondLargestElement(arr, n);
        int sS = obj.findSecondSmallestElement(arr, n);

        System.out.println("Second smallest : " + sS);
        System.out.println("Second largest : " + sL);
    }
}
