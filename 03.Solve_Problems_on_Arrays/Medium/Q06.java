// You are given an array of prices where prices[i] is the price of a given stock on an ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class Q06 {
    public int stockbuySell(int[] arr, int n) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < minPrice) {
                minPrice = arr[i];
            } else {
                maxProfit = Math.max(maxProfit, arr[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        int[] arr = { 7, 1, 5, 3, 6, 4 };
        int n = arr.length;

        Q06 obj = new Q06();

        int ans = obj.stockbuySell(arr, n);
        System.out.println(ans);

    }
}
