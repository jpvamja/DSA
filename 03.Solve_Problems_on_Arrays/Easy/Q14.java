// Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

import java.util.HashMap;
import java.util.Map;

public class Q14 {
    public int getLongestSubarray(int[] a, int k) {

        int n = a.length;
        Map<Integer, Integer> preSumMap = new HashMap<>(); 
        int sum = 0;      
        int maxLen = 0;  

        for (int i = 0; i < n; i++) {
            sum += a[i]; 

            if (sum == k) {
                maxLen = i + 1;
            }

            int rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem); 
                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = { -1, 1, 1 };
        int k = 1;

        Q14 obj = new Q14();
        int len = obj.getLongestSubarray(a, k);

        System.out.println(len);
    }
}
