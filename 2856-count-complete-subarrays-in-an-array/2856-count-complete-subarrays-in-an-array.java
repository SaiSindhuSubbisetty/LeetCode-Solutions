import java.util.*;
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num:nums)
        {
            set.add(num);
        }
        int count = 0;
        int totalDistinct = set.size();
        for(int left=0;left<n;left++)
        {
            Set<Integer> seen = new HashSet<>();
            for(int right=left;right<n;right++)
            {
                seen.add(nums[right]);
                if(seen.size() == totalDistinct)
                {
                    count++;
                }
            }
        }
        return count;
        
    }
}