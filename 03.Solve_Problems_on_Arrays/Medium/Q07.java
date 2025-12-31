// There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.

public class Q07 {
    public int[] arrayManipulate(int[] arr, int n) {
        
        int[] ans = new int[n];

        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                ans[negIndex] = arr[i];
                negIndex += 2;
            } else {
                ans[posIndex] = arr[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, -3, -1, -2, 3 };
        int n = arr.length;

        Q07 obj = new Q07();

        int[] ans = obj.arrayManipulate(arr, n);

        for (int x : ans) {
            System.out.print(x + " ");
        }

    }
}
