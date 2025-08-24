class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0,zeros = 0;
        int n = nums.length;
        int left = 0;
        for(int right = 0;right<n;right++)
        {
            if(nums[right] == 0)
            {
                zeros++;
            }
            while(zeros > 1)
            {
                if(nums[left] == 0)
                {
                    zeros--;
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen-1;
    }
}