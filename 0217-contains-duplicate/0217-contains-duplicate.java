import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num : nums){
            if(!hset.add(num))
            {
                return true;
            }
        }
        return false;

    }
}
