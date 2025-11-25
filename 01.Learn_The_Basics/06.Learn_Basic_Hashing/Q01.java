// Given an array, we have found the number of occurrences of each element in the array.

import java.util.HashMap;
import java.util.Map;

class Q01 {

    public void Frequency(int[] arr, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        int[] arr = { 10, 5, 10, 15, 10, 5 };
        int n = arr.length;

        Q01 obj = new Q01();

        obj.Frequency(arr, n);
    }
}