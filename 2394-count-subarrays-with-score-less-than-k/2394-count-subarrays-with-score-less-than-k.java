class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long sum = 0;
        int i = 0;
        //Sliding Window : (j-i+1)
        for(int j=0;j<n;j++)
        {
            sum += nums[j];
            while(i<=j && sum*(j-i+1)>=k)
            {
                sum -= nums[i];
                i++;
            }
            ans += (j-i+1);
        }
        return ans;

        
    }
}