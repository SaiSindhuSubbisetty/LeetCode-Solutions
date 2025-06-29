import java.util.*;
class Solution {
    public int numSubseq(int[] nums, int target) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        int count = 0;

        //Sort to enable two-pointer stratergy
        Arrays.sort(nums);

        int[] powerOfTwo = new int[n];
        powerOfTwo[0] = 1;
        for(int i=1; i<n; i++){
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % MOD;
        }

        int left = 0, right = n-1;
        while(left <= right){
            if(nums[left] + nums[right] <= target){
                count = (count + powerOfTwo[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        return count;
        
    }
}