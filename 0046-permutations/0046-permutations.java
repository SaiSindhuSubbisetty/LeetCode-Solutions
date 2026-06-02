class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        backTrack(nums,result,current,used);
        return result;
    }
    private void backTrack(int[] nums,List<List<Integer>> result,List<Integer> current,boolean[] used)
    {
        if(current.size() == nums.length)
        {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!used[i])
            {
                current.add(nums[i]);
                used[i] = true;
                backTrack(nums,result,current,used);
                used[i] = false;
                current.remove(current.size()-1);
            }
        }
    }
}