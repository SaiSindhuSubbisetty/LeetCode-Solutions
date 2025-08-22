import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
        
    }
    private void backtrack(int[] nums, int index, List<Integer> temp, List<List<Integer>> result){
            result.add(new ArrayList<>(temp));
            for(int i=index;i<nums.length;i++)
            {
                temp.add(nums[i]);
                backtrack(nums,i+1,temp,result);
                temp.remove(temp.size()-1);
            }
    }
}
