import java.util.*;
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] indexedNums = new int[n][2];
        for(int i=0;i<n;i++)
        {
            indexedNums[i][0]=i;
            indexedNums[i][1]=nums[i];
        }
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(b[1], a[1]));
        int[][] topK = Arrays.copyOfRange(indexedNums, 0, k);
        Arrays.sort(topK, Comparator.comparingInt(a -> a[0]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][1];
        }
        return result;

        
    }
}