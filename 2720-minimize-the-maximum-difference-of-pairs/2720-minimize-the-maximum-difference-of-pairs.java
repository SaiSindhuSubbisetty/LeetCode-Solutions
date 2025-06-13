class Solution 
{
    public int minimizeMax(int[] nums, int p) 
    {
        // Step 1: Sort the array
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        // Step 3: Binary search
        while (low < high) 
        {
            int mid = (low + high) >>> 1;

            if (canFormPairs(nums, p, mid)) 
            {
                high = mid;
            } 
            else 
            {
                low = mid + 1;
            }
        }

        // Step 5: Final answer
        return low;
    }

    // Step 4: Greedy pair formation
    public boolean canFormPairs(int[] nums, int p, int maxDiff) 
    {
        int count = 0;
        for (int i = 1; i < nums.length && count < p;) 
        {
            if (nums[i] - nums[i - 1] <= maxDiff) 
            {
                count++;
                i += 2;
            } 
            else 
            {
                i++;
            }
        }
        
        return count >= p;
    }
}