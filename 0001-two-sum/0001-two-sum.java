import java.util.*;
 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<=nums.length; i++)
        {
            int complement = target - nums[i];
            if(hmap.containsKey(complement))
            {
                return new int[]{hmap.get(complement), i};
            }
            hmap.put(nums[i], i);
        }
        return new int[]{};

       
    }
}
