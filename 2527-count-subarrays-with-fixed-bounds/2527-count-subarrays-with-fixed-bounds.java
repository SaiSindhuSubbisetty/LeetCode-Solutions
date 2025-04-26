class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int right = 0,left = -1;
        int minIndex = -1,maxIndex=-1;
        long result = 0;
        for(;right<nums.length;right++)
        {
            if(nums[right]<minK || nums[right]>maxK)
            {
                left = right;
            }
            if(nums[right] == minK)
            {
                minIndex = right;
            }
            if(nums[right] == maxK){
                maxIndex = right;
            }
            result += Math.max(0L,Math.min(minIndex,maxIndex)-left);
        }
        return result;
        
    }
}