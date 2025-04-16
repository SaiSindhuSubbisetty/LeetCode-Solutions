import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> hmap = new HashMap<>();
       int n = nums.length;
       for(int i=0;i<n;i++)
       {
         int compliment = target - nums[i];
         if(hmap.containsKey(compliment))
         {
            return new int []{hmap.get(compliment),i};
         }
         hmap.put(nums[i],i);
       }
       return new int[]{};
    }

}
