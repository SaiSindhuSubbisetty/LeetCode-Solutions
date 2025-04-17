import java.util.*;

public class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;

        // Step 1: Map to group indices by the value of nums[i]
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            // Group all indices for each value
            if(!valueToIndices.containsKey(nums[i])){
                valueToIndices.put(nums[i], new ArrayList<>());
            }
            valueToIndices.get(nums[i]).add(i);
        }

        // Step 2: For each group of equal numbers, check pairs of indices
        for(List<Integer> indices : valueToIndices.values()){
            int size = indices.size();
              // Check all pairs in this group
            for(int i=0;i<size;i++){
                for(int j=i+1;j<size;j++){
                    int index1 = indices.get(i);
                    int index2 = indices.get(j);
                    if((index1*index2)%k == 0){
                        count++;
                    }
                }
            }
        }
         return count;
    }
}
