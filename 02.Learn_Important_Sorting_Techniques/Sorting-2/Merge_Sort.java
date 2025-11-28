// Given an array of size n, sort the array using Merge Sort.

import java.util.ArrayList;
import java.util.List;

public class Merge_Sort {
    public void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }
        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public void merge_sort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;

        merge_sort(arr, low, mid);

        merge_sort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {

        int[] arr = { 5, 2, 8, 4, 1 };

        Merge_Sort obj = new Merge_Sort();

        obj.merge_sort(arr, 0, arr.length - 1);

        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
