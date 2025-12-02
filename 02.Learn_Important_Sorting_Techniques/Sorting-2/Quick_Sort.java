// Given an array of n integers, sort the array using the Quicksort method.

public class Quick_Sort {
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public void quick_sort(int[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quick_sort(arr, low, pivotIndex - 1);

            quick_sort(arr, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 10, 7, 8, 9, 1, 5 };

        Quick_Sort obj = new Quick_Sort();

        obj.quick_sort(arr, 0, arr.length - 1);

        for (int num : arr)
            System.out.print(num + " ");
    }
}
