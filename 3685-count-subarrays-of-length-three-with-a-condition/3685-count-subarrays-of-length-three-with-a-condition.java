class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        int n  = nums.length;
        for(int i=0;i<=n-3;i++)
        {
            int first = nums[i];
            int second = nums[i+1];
            int third = nums[i+2];
            if(second%2 == 0 && first+third == second/2)
            {
                count++;
            }
        }
        return count;
        
    }
}