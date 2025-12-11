// Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.

import java.util.ArrayList;
import java.util.List;

public class Q09 {
    public List<Integer> UnionOfTwoArrays(int[] arr1, int[] arr2, int n, int m) {

        List<Integer> Union = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {

            if (arr1[i] < arr2[j]) {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            } else {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
                j++;
            }
        }

        while (i < n) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }

        while (j < m) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr2 = { 2, 3, 4, 4, 5, 11, 12 };

        int n = arr1.length;
        int m = arr2.length;

        Q09 obj = new Q09();
        List<Integer> result = obj.UnionOfTwoArrays(arr1, arr2, n, m);

        for (int x : result)
            System.out.print(x + " ");

    }
}
