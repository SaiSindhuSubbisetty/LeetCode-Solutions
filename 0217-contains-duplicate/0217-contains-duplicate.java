import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(seen.contains(nums[i]))
            {
                return true;
            }
            seen.add(nums[i]);
        }
        return false;

    }
}
