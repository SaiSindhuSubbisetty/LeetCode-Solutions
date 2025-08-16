import java.util.*;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> remainderCount = new HashMap<>();
        remainderCount.put(0,1);
        int sum = 0;
        int count = 0;
        for(int num : nums){
            sum += num;
            int remainder = sum%k;
            if(remainder < 0) remainder += k;
            if(remainderCount.containsKey(remainder))
            {
                count += remainderCount.getOrDefault(remainder, 0);
            }
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder,0)+1);
            
        }
        return count;
        
    }
}
